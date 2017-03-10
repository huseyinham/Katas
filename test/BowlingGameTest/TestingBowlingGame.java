package BowlingGameTest;

import BowlingGame.BowlingGame;
import junit.framework.TestCase;

public class TestingBowlingGame extends TestCase {

    BowlingGame game;

    protected void setUp(){
        game = new BowlingGame();
    }

    private void rollMany(int numberOfTurns, int pins) {
        for(int turns = 0; turns < numberOfTurns; turns++){
            game.roll(pins);
        }
    }

    public void testGutterGame() throws Exception {
        rollMany(20,0);
        assertEquals(0, game.score());
    }

    public void testAllOnes() throws Exception {
        rollMany(20,1);
        assertEquals(20, game.score());
    }

    public void testSpare() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17,0);
        assertEquals(16, game.score());
    }

    public void testStrike() throws Exception {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16,0);
        assertEquals(24, game.score());
    }

    public void testPerfectGame() throws Exception {
        rollMany(12,10);
        assertEquals(300, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }
}