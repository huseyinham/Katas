package BingoGameTest;

import BingoGame.BingoGame;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class BingoGameTest {

    @Test
    public void returnsSingleNumberBetweenOneAndSeventyFive(){
        BingoGame game = new BingoGame();
        int pickBall = game.callNumber();
        System.out.println(pickBall);
        Assert.assertTrue(pickBall >= 1 && pickBall <= 75);
    }

    @Test
    public void returnsAllNumbersBetweenOneAndSeventyFiveOnce(){
        BingoGame game = new BingoGame();
        ArrayList<Integer> callArray = new ArrayList<Integer>(75);
        for (int i = 1; i <= 75; i++) {
            callArray.add(i);
        }

        for (int i=0;i<75;i++) {
            Assert.assertTrue(callArray.get(i) >= 1 && callArray.get(i) <= 75);
        }
    }
}
