package BingoGameTest;

import BingoGame.Card;
import BingoGame.NumberGenerator;
import org.junit.Test;


public class CardTest {

    NumberGenerator numberGenerator = new NumberGenerator();
    Card card = new Card(numberGenerator.generate());

    @Test



}
