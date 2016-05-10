package BingoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BingoGame {
    private List<Integer> listOfPossibleNumbers;
    private final Random random = new Random();
    private final List<Column> columns = new ArrayList<>();

    public BingoGame(NumberGenerator numberGenerator) {
        listOfPossibleNumbers = numberGenerator.generate();
    }

    public int callNumber() {
        int rolledNumber = random.nextInt(listOfPossibleNumbers.size());
        return listOfPossibleNumbers.remove(rolledNumber);
    }

    public void generateStartingBingoCard() {
        columns.add(createColumn(1, 15));
        columns.add(createColumn(16, 30));
        columns.add(createColumn(31, 45));
        columns.add(createColumn(46, 60));
        columns.add(createColumn(61, 75));
    }

    public void printCard() {
        int rowCount = columns.get(0).getRowCount();
        for (int i = rowCount-1; i >= 0; i--) {
            printRow(i);
        }
    }

    private void printRow(int i) {
        for(Column column : columns){
            System.out.print(column.getRowNumber(i) + "\t");
        }
        System.out.println();
    }

    private Column createColumn(int min, int max) {
        return new Column(min, max, listOfPossibleNumbers);
    }
}