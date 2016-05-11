package TennisGame;

public class TennisGame {

    private int playerOneScore;
    private int playerTwoScore;
    private boolean playerOneHasScored;
    private boolean playerTwoHasScored;

    public void main(String[] args) {
        score(true, playerOneScore);
        score(false, playerTwoScore);
    }

    public void startGame() {
        playerOneScore = 0;
        playerTwoScore = 0;
    }

    public int score(boolean playerOneHasScored, int scoringPlayersCurrentScore) {
        if (playerOneHasScored) {
            playerOneScore = playerOneScorePoint(scoringPlayersCurrentScore);
            return playerOneScore;
        } else {
            playerTwoScore = playerTwoScorePoint(scoringPlayersCurrentScore);
        }
        return playerTwoScore;
    }

    private int playerOneScorePoint(int playerOneScore) {
        playerOneScore += 15;
        return playerOneScore;
    }

    private int playerTwoScorePoint(int playerTwoScore) {
        playerTwoScore += 15;
        return playerTwoScore;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
}
