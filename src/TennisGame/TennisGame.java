package TennisGame;

public class TennisGame {

    private int playerOneScore;
    private int playerTwoScore;
    private static final int ace = 65;

    public void main(String[] args) {
        //enter '1' when player one scores or '2' if player two scores
        //if scanner = '1' then
        score(true, playerOneScore, playerTwoScore);
        //else if scanner = '2' then
        score(false, playerTwoScore, playerOneScore);
        hasWon(playerOneScore, playerTwoScore);

        checkIfAce();
    }

    public void startGame() {
        playerOneScore = 0;
        playerTwoScore = 0;
    }

    public int score(boolean playerOneHasScored, int scoringPlayersCurrentScore, int otherPlayersCurrentScore) {
        if (playerOneHasScored) {
            playerOneScore = playerOneScorePoint(scoringPlayersCurrentScore, otherPlayersCurrentScore);
            return playerOneScore;
        } else {
            playerTwoScore = playerTwoScorePoint(scoringPlayersCurrentScore, otherPlayersCurrentScore);
        }
        return playerTwoScore;
    }

    private int playerOneScorePoint(int playerOneScore, int otherPlayersScore) {
        if (playerOneScore == 40 && otherPlayersScore == 40) {
            playerOneScore = ace;
        } else if (playerOneScore == 40 && otherPlayersScore == 65) {
            playerTwoScore = 40;
        } else if (playerOneScore == 30) {
            playerOneScore += 10;
        } else {
            playerOneScore += 15;
        }
        return playerOneScore;
    }

    private int playerTwoScorePoint(int playerTwoScore, int otherPlayersScore) {
        if (playerTwoScore == 40 && otherPlayersScore <= 40) {
            playerTwoScore = ace;
        } else if (playerTwoScore == 40 && otherPlayersScore == 65) {
            playerOneScore = 40;
        } else if (playerTwoScore == 30) {
            playerTwoScore += 10;
        } else {
            playerTwoScore += 15;
        }
        return playerTwoScore;
    }

    private void checkIfAce() {
        if (playerOneScore == 65) {
            getAce(playerOneScore);
        } else if (playerTwoScore == 65) {
            getAce(playerTwoScore);
        }
    }

    private String getAce(int playerScore) {
        System.out.println(String.valueOf(playerScore));
        return String.valueOf(playerScore);
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public boolean hasWon(int scorer, int otherPlayer) {
        return scorer == 40 && otherPlayer < 40 || scorer == 65 && otherPlayer == 40;
    }
}
