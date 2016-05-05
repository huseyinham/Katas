package connectFour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectFour {

    /* The grid is referenced using 0-5 (rows) and 0-6 (columns)
       however the dropColumn (where the token is input) is referenced
       using 1-6 (the column it is dropped into).
     */

    private int[][] grid = new int[6][7];
    private static final int redColour = 1;
    private static final int yellowColour = 2;
    private static int currentPlayer = redColour;

    public static void main(String[] args) {
        ConnectFour connectFour = new ConnectFour();
        while (true) {
            System.out.println("Player " + currentPlayer + ", please select a column.");
            Scanner sc = new Scanner(System.in);
            int Column = sc.nextInt();
            try {
                connectFour.placingToken(Column, currentPlayer);
                if (connectFour.hasWon(currentPlayer)) {
                    System.out.println("Congratulations! You have won!");
                    return;
                }
                changeCurrentPlayer();
            } catch (NoFreeSlotException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void changeCurrentPlayer() {
        if (currentPlayer == redColour) {
            currentPlayer = yellowColour;
        } else {
            currentPlayer = redColour;
        }
    }

    public void placingToken(int dropColumn, int tokenColour) {
        System.out.println("A token has been placed.");
        System.out.println("----------");
        int availableRow = getFreeSlot(dropColumn);
        grid[availableRow][dropColumn - 1] = tokenColour;
        printGrid();
    }

    private int getFreeSlot(int dropColumn) {
        for (int rowSlot = grid.length - 1; rowSlot >= 0; rowSlot--) {
            if (grid[rowSlot][dropColumn - 1] == 0) {
                return rowSlot;
            }
        }
        throw new NoFreeSlotException("No free slot found in column " + dropColumn);
    }

    private void printGrid() {
        for (int xAxis = 0; xAxis < grid.length; xAxis++) {
            for (int yAxis = 0; yAxis < grid[xAxis].length; yAxis++) {
                System.out.print(grid[xAxis][yAxis] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public int getToken(int row, int column) {
        if (row >= grid.length || row < 0)
            return -1;
        if (column >= grid[0].length || column < 0)
            return -1;
        return grid[row][column];
    }

    public boolean hasWon(int tokenColour) {
        if (hasWonVertically(tokenColour)) {
            return true;
        }

        if (hasWonHorizontally(tokenColour)) {
            return true;
        }

        return hasWonDiagonally(tokenColour);
    }

    private boolean hasWonVertically(int tokenColour) {
        for (int column = 0; column < grid[0].length; column++) {
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                if (getToken(row, column) == tokenColour) {
                    count++;
                    if (count == 4)
                        return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean hasWonHorizontally(int tokenColour) {
        for (int row = 0; row < grid.length; row++) {
            int count = 0;
            for (int column = 0; column < grid[0].length; column++) {
                if (getToken(row, column) == tokenColour) {
                    count++;
                    if (count == 4)
                        return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean hasWonDiagonally(int tokenColour) {
        for (int startRow = 0; startRow < grid.length; startRow++) {
            if (hasWonDiagonallyDownRight(tokenColour, startRow, 0)) {
                return true;
            }
        }

        for (int startColumn = 1; startColumn < grid.length; startColumn++) {
            if (hasWonDiagonallyDownRight(tokenColour, 0, startColumn)) {
                return true;
            }
        }

        for (int startColumn = grid.length - 1; startColumn >= 0; startColumn--) {
            if (hasWonDiagonallyDownLeft(tokenColour, 0, startColumn)) {
                return true;
            }
        }

        for (int startRow = 1; startRow < grid.length - 1; startRow++) {
            if (hasWonDiagonallyDownLeft(tokenColour, startRow, grid[0].length - 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasWonDiagonallyDownRight(int tokenColour, int startRow, int startColumn) {
        int column = startColumn;
        int count = 0;
        for (int row = startRow; row < grid.length; row++, column++) {
            if (getToken(row, column) == tokenColour) {
                count++;
            } else {
                count = 0;
            }
            if (count == 4) return true;
        }
        return false;
    }

    private boolean hasWonDiagonallyDownLeft(int tokenColour, int startRow, int startColumn) {
        int column = startColumn;
        int count = 0;
        for (int row = startRow; row < grid.length; row++, column--) {
            if (getToken(row, column) == tokenColour) {
                count++;
            } else {
                count = 0;
            }
            if (count == 4) return true;
        }
        return false;
    }
}
