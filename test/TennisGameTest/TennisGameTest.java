package TennisGameTest;

import TennisGame.TennisGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {

    private TennisGame tennisGame;

    @Before
    public void setUp() {
        tennisGame = new TennisGame();
    }

    @Test
    public void blankScoreAtStartGame() {
        Assert.assertEquals("0", tennisGame.getPlayerOneScore());
        Assert.assertEquals("0", tennisGame.getPlayerTwoScore());
    }

    @Test
    public void scorePointForPlayerOne() {
        tennisGame.playerOneScorePoint();
        Assert.assertEquals("15", tennisGame.getPlayerOneScore());
    }

    @Test
    public void scorePointForPlayerTwo() {
        tennisGame.playerOneScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        Assert.assertEquals("30", tennisGame.getPlayerTwoScore());
    }

    @Test
    public void score40ForPlayerOne() {
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();
        Assert.assertEquals("40", tennisGame.getPlayerOneScore());
    }

    @Test
    public void score40ForPlayerTwo() {
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        Assert.assertEquals("40", tennisGame.getPlayerTwoScore());
    }

    @Test
    public void scoreValueOfAceForPlayerOne() {
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();

        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();

        tennisGame.playerOneScorePoint();
        Assert.assertEquals("A", tennisGame.getPlayerOneScore());
    }

    @Test
    public void scoreValueOfAceForPlayerTwo() {
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();

        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();

        tennisGame.playerTwoScorePoint();
        Assert.assertEquals("A", tennisGame.getPlayerTwoScore());
    }

    @Test
    public void whilePlayerTwoHasAceReducePlayerTwoScoreIfPlayerOneScores() {
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();

        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();

        tennisGame.playerOneScorePoint();
        Assert.assertEquals("40", tennisGame.getPlayerTwoScore());
    }

    @Test
    public void whilePlayerOneHasAceReducePlayerOneScoreIfPlayerTwoScores() {
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();

        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();

        tennisGame.playerOneScorePoint();

        tennisGame.playerTwoScorePoint();
        Assert.assertEquals("40", tennisGame.getPlayerOneScore());
    }

    @Test
    public void playerOneWinsFrom40() {
        tennisGame.playerOneScorePoint();
        System.out.println(tennisGame.getPlayerOneScore());
        tennisGame.playerOneScorePoint();
        System.out.println(tennisGame.getPlayerOneScore());
        tennisGame.playerOneScorePoint();
        System.out.println(tennisGame.getPlayerOneScore());
        tennisGame.playerOneScorePoint();
        System.out.println(tennisGame.getPlayerOneScore());
        Assert.assertTrue(tennisGame.hasPlayerOneWon());
    }

    @Test
    public void playerTwoWinsFrom40() {
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        Assert.assertTrue(tennisGame.hasPlayerTwoWon());
    }

    @Test
    public void playerOneWinsFromAce() {
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();

        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();

        tennisGame.playerOneScorePoint();

        tennisGame.playerOneScorePoint();
        Assert.assertTrue(tennisGame.hasPlayerOneWon());
    }

    @Test
    public void playerTwoWinsFromAce() {
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();
        tennisGame.playerOneScorePoint();

        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();
        tennisGame.playerTwoScorePoint();

        tennisGame.playerTwoScorePoint();

        tennisGame.playerTwoScorePoint();
        Assert.assertTrue(tennisGame.hasPlayerTwoWon());
    }
}