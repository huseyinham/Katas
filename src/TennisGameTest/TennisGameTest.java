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
        //tennisGame.startGame();
        Assert.assertEquals(0, tennisGame.getPlayerOneScore());
        Assert.assertEquals(0, tennisGame.getPlayerTwoScore());
    }

    @Test
    public void scorePointForPlayerOne() {
        tennisGame.score(true, 0, 0);
        Assert.assertEquals(15, tennisGame.getPlayerOneScore());
    }

    @Test
    public void scorePointForPlayerTwo() {
        tennisGame.score(false, 15, 0);
        Assert.assertEquals(30, tennisGame.getPlayerTwoScore());
    }

    @Test
    public void score40ForPlayerOne() {
        tennisGame.score(true, 30, 0);
        Assert.assertEquals(40, tennisGame.getPlayerOneScore());
    }

    @Test
    public void score40ForPlayerTwo() {
        tennisGame.score(false, 30, 0);
        Assert.assertEquals(40, tennisGame.getPlayerTwoScore());
    }

    @Test
    public void scoreValueOfAceForPlayerOne() {
        tennisGame.score(true, 40, 0);
        Assert.assertEquals(65, tennisGame.getPlayerOneScore());
    }

    @Test
    public void scoreValueOfAceForPlayerTwo() {
        tennisGame.score(false, 40, 0);
        Assert.assertEquals(65, tennisGame.getPlayerTwoScore());
    }

    @Test
    public void returnLetterAForPlayerOneInsteadOf65() {
        tennisGame.score(true, 40, 0);
        Assert.assertEquals('A', tennisGame.getPlayerOneScore());
    }

    @Test
    public void returnLetterAForPlayerTwoInsteadOf65() {
        tennisGame.score(false, 40, 0);
        Assert.assertEquals('A', tennisGame.getPlayerTwoScore());
    }
}
