package BingoGameTest;

import BingoGame.NumberGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NumberGeneratorTest {

    private NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    public void returnsAllNumbersBetweenOneAndSeventyFiveOnce() {
        List<Integer> results = numberGenerator.generate();
        // checks that the arraylist contains one of each numbers up to 75
        for (int i = 0; i < 75; i++) {
            Assert.assertTrue(results.contains(i + 1));
        }
    }

}
