package BingoGameTest;

import BingoGame.BingoGame;
import BingoGame.Column;
import BingoGame.NumberGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class BingoGameTest {

    private BingoGame game;

    @Before
    public void initialize() {
        game = new BingoGame(new NumberGenerator());
    }

    @Test
    public void returnsSingleNumberBetweenOneAndSeventyFive() {
        int pickBall = game.callNumber();
        Assert.assertTrue(pickBall >= 1 && pickBall <= 75);
    }

    @Test
    public void returnsAllNumbersBetweenOneAndSeventyFiveOnce() {
        List<Integer> results = new ArrayList<>(75);
        // calls the method to draw a ball 75 times
        for (int i = 0; i < 75; i++) {
            results.add(game.callNumber());
        }
        // checks that the arraylist contains one of each numbers up to 75
        for (int i = 0; i < 75; i++) {
            Assert.assertTrue(results.contains(i + 1));
        }
    }

    @Test
    public void generateAStartingBingoCard() {
        List<Integer> allPossibleNumbers = new ArrayList<>();
        for (int i = 0; i < 75; i++) {
            allPossibleNumbers.add(game.callNumber());
        }

        List<Column> bingoCardColumns = new ArrayList<>();
        game.generateStartingBingoCard();
        for(int i = 0; i <= 25; i++){
            bingoCardColumns.add(new Column(1, 15, allPossibleNumbers));
            //Assert.assertTrue(bingoCardColumns.get(i) >= 1 && bingoCardColumns.get(i) <=15);
        }

        System.out.println(bingoCardColumns.get(1).asString());
        //game.printCard();
    }
}
