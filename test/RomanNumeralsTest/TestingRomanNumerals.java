package RomanNumeralsTest;

import RomanNumeralsCode.RomanNumerals;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class TestingRomanNumerals {

    RomanNumerals romanConverter = new RomanNumerals();

    //Tests basic roman numeral letters
    @Test
    public void entering1000GivesYouM(){
        assertEquals("M", romanConverter.numberToNumeral(1000));
    }

    @Test
    public void entering500GivesYouD(){
        assertEquals("D", romanConverter.numberToNumeral(500));
    }

    @Test
    public void entering100GivesYouC(){
        assertEquals("C", romanConverter.numberToNumeral(100));
    }

    @Test
    public void entering50GivesYouL(){
        assertEquals("L", romanConverter.numberToNumeral(50));
    }

    @Test
    public void entering10GivesYouX(){
        assertEquals("X", romanConverter.numberToNumeral(10));
    }

    @Test
    public void entering5GivesYouV(){
        assertEquals("V", romanConverter.numberToNumeral(5));
    }

    @Test
    public void entering1GivesYouI(){
        assertEquals("I", romanConverter.numberToNumeral(1));
    }

    //Tests letters that require deductions from another letter i.e. IX
    @Test
    public void entering900GivesYouCM(){
        assertEquals("CM", romanConverter.numberToNumeral(900));
    }

    @Test
    public void entering600GivesYouDC(){
        assertEquals("DC", romanConverter.numberToNumeral(600));
    }

    @Test
    public void entering400GivesYouCD(){
        assertEquals("CD", romanConverter.numberToNumeral(400));
    }

    @Test
    public void entering90GivesYouXC(){
        assertEquals("XC", romanConverter.numberToNumeral(90));
    }

    @Test
    public void entering40GivesYouXL(){
        assertEquals("XL", romanConverter.numberToNumeral(40));
    }

    //Kata/Scenario tests that were given
    @Test
    public void entering1066GivesYouMLXVI(){
        assertEquals("MLXVI", romanConverter.numberToNumeral(1066));
    }

    @Test
    public void entering1989GivesYouMCMLXXXIX(){
        assertEquals("MCMLXXXIX", romanConverter.numberToNumeral(1989));
    }

    //Ensure number entered cannot be 4000 or higher
    @Test
    public void entering8000GivesYouAnErrorMessage(){
        assertEquals("Number too large", romanConverter.numberToNumeral(8000));
    }
}