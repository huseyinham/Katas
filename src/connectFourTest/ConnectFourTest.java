package connectFourTest;

import connectFour.ConnectFour;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;


public class ConnectFourTest {

    ConnectFour game = new ConnectFour();

    private static final int redColour = 1;
    private static final int yellowColour = 2;

    /*Testing that a token can be placed into each column*/
    @Test
    public void insertTokenIntoSixthRowFirstColumn(){
        game.placingToken(1,redColour);
        assertEquals(redColour, game.getToken(5,0));
    }

    @Test
    public void insertTokenIntoSixthRowSecondColumn(){
        game.placingToken(2,redColour);
        assertEquals(redColour, game.getToken(5,1));
    }

    @Test
    public void insertTokenIntoSixthRowThirdColumn(){
        game.placingToken(3,redColour);
        assertEquals(redColour, game.getToken(5,2));
    }

    @Test
    public void insertTokenIntoSixthRowFourthColumn(){
        game.placingToken(4,redColour);
        assertEquals(redColour, game.getToken(5,3));
    }

    @Test
    public void insertTokenIntoSixthRowFifthColumn(){
        game.placingToken(5,redColour);
        assertEquals(redColour, game.getToken(5,4));
    }

    @Test
    public void insertTokenIntoSixthRowSixthColumn(){
        game.placingToken(6,redColour);
        assertEquals(redColour, game.getToken(5,5));
    }

    @Test
    public void insertTokenIntoBottomRowSeventhColumn(){
        game.placingToken(7,redColour);
        assertEquals(redColour, game.getToken(5,6));
    }

    /*Testing that a token can be placed into each column that is previously
    filled with another token*/
    @Test
    public void insertTokenIntoFifthRowFirstColumnIfSixthRowIsFilled(){
        game.placingToken(1,redColour);
        game.placingToken(1,redColour);
        assertEquals(redColour, game.getToken(4,0));
    }

    @Test
    public void insertTokenIntoFifthRowSecondColumnIfSixthRowIsFilled(){
        game.placingToken(2,redColour);
        game.placingToken(2,redColour);
        assertEquals(redColour, game.getToken(4,1));
    }

    @Test
    public void insertTokenIntoFifthRowThirdColumnIfSixthRowIsFilled(){
        game.placingToken(3,redColour);
        game.placingToken(3,redColour);
        assertEquals(redColour, game.getToken(4,2));
    }

    @Test
    public void insertTokenIntoFifthRowFourthColumnIfSixthRowIsFilled(){
        game.placingToken(4,redColour);
        game.placingToken(4,redColour);
        assertEquals(redColour, game.getToken(4,3));
    }

    @Test
    public void insertTokenIntoFifthRowFifthColumnIfSixthRowIsFilled(){
        game.placingToken(5,redColour);
        game.placingToken(5,redColour);
        assertEquals(redColour, game.getToken(4,4));
    }

    @Test
    public void insertTokenIntoFifthRowSixthColumnIfSixthRowIsFilled(){
        game.placingToken(6,redColour);
        game.placingToken(6,redColour);
        assertEquals(redColour, game.getToken(4,5));
    }

    @Test
    public void insertTokenIntoFifthRowSeventhColumnIfSixthRowIsFilled(){
        game.placingToken(7,redColour);
        game.placingToken(7,redColour);
        assertEquals(redColour, game.getToken(4,6));
    }

    /*Testing if a token will be placed correctly if two slots have been
    filled in the column*/
    @Test
    public void insertTokenIntoFourthRowFirstColumnIfSixthAndFifthRowIsFilled(){
        game.placingToken(1,redColour);
        game.placingToken(1,redColour);
        game.placingToken(1,redColour);
        assertEquals(redColour, game.getToken(3,0));
    }

    /*Checking that yellow tokens are accepted - as well as red tokens
    that were used previously*/
    @Test
    public void yellowAndRedTokenInsertion(){
        game.placingToken(1,yellowColour);
        game.placingToken(1,redColour);
        assertEquals(yellowColour, game.getToken(5,0));
        assertEquals(redColour, game.getToken(4,0));
    }

    /*Testing error message when too many tokens are put into one column*/
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void tooManyTokensInOneColumn(){
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("No free slot found in column " + 1);
        game.placingToken(1, yellowColour);
        game.placingToken(1, yellowColour);
        game.placingToken(1, yellowColour);
        game.placingToken(1, redColour);
        game.placingToken(1, redColour);
        game.placingToken(1, redColour);
        game.placingToken(1, yellowColour);
    }
    @Test
    public void initialGameShouldNotBeWon() {
        assertEquals(false, game.hasWon(yellowColour));
        assertEquals(false, game.hasWon(redColour));
    }

    /*Checking that the win conditions are in place*/
    @Test
    public void yellowTokenWinsVertically(){
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(1,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(1,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(1,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(1,yellowColour);
        assertEquals(true, game.hasWon(yellowColour));
    }

    @Test
    public void yellowTokenWinsVerticallyInAnotherColumn(){
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(5,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(5,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(5,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(5,yellowColour);
        assertEquals(true, game.hasWon(yellowColour));
    }

    @Test
    public void yellowTokenWinsHorizontally(){
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(1,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(2,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(3,yellowColour);
        assertEquals(false, game.hasWon(yellowColour));
        game.placingToken(4,yellowColour);
        assertEquals(true, game.hasWon(yellowColour));
    }

    @Test
    public void yellowTokenWinsDiagonally(){
        game.placingToken(1,yellowColour);
        game.placingToken(2,redColour);
        game.placingToken(2,yellowColour);
        game.placingToken(3,yellowColour);
        game.placingToken(3,redColour);
        game.placingToken(3,yellowColour);
        game.placingToken(4,redColour);
        game.placingToken(4,redColour);
        game.placingToken(4,redColour);
        game.placingToken(4,yellowColour);
        assertEquals(true, game.hasWon(yellowColour));
    }

    @Test
    public void yellowTokenWinsDiagonallyAgain(){
        game.placingToken(3,yellowColour);
        game.placingToken(4,redColour);
        game.placingToken(4,yellowColour);
        game.placingToken(5,yellowColour);
        game.placingToken(5,redColour);
        game.placingToken(5,yellowColour);
        game.placingToken(6,redColour);
        game.placingToken(6,redColour);
        game.placingToken(6,redColour);
        game.placingToken(6,yellowColour);
        assertEquals(true, game.hasWon(yellowColour));
    }

    @Test
    public void yellowTokenWinsDiagonallyInDifferentDirection(){
        game.placingToken(1,redColour);
        game.placingToken(1,redColour);
        game.placingToken(1,redColour);
        game.placingToken(1,yellowColour);
        game.placingToken(2,redColour);
        game.placingToken(2,redColour);
        game.placingToken(2,yellowColour);
        game.placingToken(3,redColour);
        game.placingToken(3,yellowColour);
        game.placingToken(4,yellowColour);
        assertEquals(true, game.hasWon(yellowColour));
    }

    @Test
    public void yellowTokenWinsDiagonallyInDifferentDirectionAgain(){
        game.placingToken(4,redColour);
        game.placingToken(4,redColour);
        game.placingToken(4,redColour);
        game.placingToken(4,yellowColour);
        game.placingToken(5,redColour);
        game.placingToken(5,redColour);
        game.placingToken(5,yellowColour);
        game.placingToken(6,redColour);
        game.placingToken(6,yellowColour);
        game.placingToken(7,yellowColour);
        assertEquals(true, game.hasWon(yellowColour));
    }
}
