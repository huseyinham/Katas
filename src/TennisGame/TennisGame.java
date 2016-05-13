package TennisGame;

import java.util.Scanner;

public class TennisGame {

    private int playerOneScore;
    private int playerTwoScore;
    private static final int ace = 65;

    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();
        tennisGame.startGame();
        Scanner scan = new Scanner(System.in);
        while (!tennisGame.gameHasBeenWon()) {
            System.out.println("Enter '1' if player one has scored or '2' if player two has scored.");
            int chooseScorer = scan.nextInt();
            if (chooseScorer == 1) {
                tennisGame.playerOneScorePoint();
                if(tennisGame.hasPlayerOneWon()){
                    System.out.println("Player One has won.");
                } else {
                    System.out.println("Player One: " + tennisGame.getPlayerOneScore() + " - Player Two: " + tennisGame.getPlayerTwoScore());
                }
            } else if (chooseScorer == 2) {
                tennisGame.playerTwoScorePoint();
                if(tennisGame.hasPlayerTwoWon()){
                    System.out.println("Player Two has won.");
                } else {
                    System.out.println("Player One: " + tennisGame.getPlayerOneScore() + " - Player Two: " + tennisGame.getPlayerTwoScore());
                }
            }
        }
    }

    public void startGame() {
        playerOneScore = 0;
        playerTwoScore = 0;
    }

    public int playerOneScorePoint() {
        if (playerOneScore == 40 && playerTwoScore == 40) {
            playerOneScore = ace;
        } else if (playerOneScore == 40 && playerTwoScore == 65) {
            playerTwoScore = 40;
        } else if (playerOneScore == 30) {
            playerOneScore += 10;
        } else {
            playerOneScore += 15;
        }
        return playerOneScore;
    }

    public int playerTwoScorePoint() {
        if (playerTwoScore == 40 && playerOneScore == 40) {
            playerTwoScore = ace;
        } else if (playerTwoScore == 40 && playerOneScore == 65) {
            playerOneScore = 40;
        } else if (playerTwoScore == 30) {
            playerTwoScore += 10;
        } else {
            playerTwoScore += 15;
        }
        return playerTwoScore;
    }

    private boolean checkIfAce(int score) {
        return score == 65;
    }

    private String getScore(int score) {
        if (checkIfAce(score)) {
            return "A";
        }
        return String.valueOf(score);
    }

    public String getPlayerOneScore() {
        return getScore(playerOneScore);
    }

    public String getPlayerTwoScore() {
        return getScore(playerTwoScore);
    }

    public boolean gameHasBeenWon(){
        return hasPlayerOneWon() || hasPlayerTwoWon();
    }

    public boolean hasPlayerOneWon() {
        return (playerOneScore > 40 && playerTwoScore < 40) || (playerOneScore > 65 && playerTwoScore == 40);
    }

    public boolean hasPlayerTwoWon() {
        return (playerTwoScore > 40 && playerOneScore < 40) || (playerTwoScore > 65 && playerOneScore == 40);
    }
}