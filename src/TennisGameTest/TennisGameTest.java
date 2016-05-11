package TennisGameTest;

import TennisGame.TennisGame;
import org.junit.Assert;
import org.junit.Test;

public class TennisGameTest {

    @Test
    public void blankScoreAtStartGame(){
        TennisGame tennisGame = new TennisGame();
        //tennisGame.startGame();
        Assert.assertEquals(0, tennisGame.getPlayerOneScore());
        Assert.assertEquals(0, tennisGame.getPlayerTwoScore());
    }

    @Test
    public void scorePointForPlayerOne(){
        TennisGame tennisGame = new TennisGame();
        tennisGame.score(true, 0);
        Assert.assertEquals(15, tennisGame.getPlayerOneScore());
    }

    @Test
    public void scorePointForPlayerTwo(){
        TennisGame tennisGame = new TennisGame();
        tennisGame.score(false, 15);
        Assert.assertEquals(30, tennisGame.getPlayerTwoScore());
    }

    @Test
    public void score40ForPlayerOne(){
        TennisGame tennisGame = new TennisGame();
        tennisGame.score(true, 30);
        Assert.assertEquals(40, tennisGame.getPlayerOneScore());
    }
}
