package RomanNumeralsTest;

import RomanNumeralsCode.ArabicNumerals;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingArabicNumerals {

    ArabicNumerals arabicConverter = new ArabicNumerals();

    //Start with the key numbers/letters in Roman Numerals
    @Test
    public void enteringMGivesYou1000(){
        assertEquals(1000, arabicConverter.numeralToNumber("M"));
    }

    @Test
    public void enteringDGivesYou500(){
        assertEquals(500, arabicConverter.numeralToNumber("D"));
    }

    @Test
    public void enteringCGivesYou100(){
        assertEquals(100, arabicConverter.numeralToNumber("C"));
    }

    @Test
    public void enteringLGivesYou50(){
        assertEquals(50, arabicConverter.numeralToNumber("L"));
    }

    @Test
    public void enteringXGivesYou10(){
        assertEquals(10, arabicConverter.numeralToNumber("X"));
    }

    @Test
    public void enteringVGivesYou5(){
        assertEquals(5, arabicConverter.numeralToNumber("V"));
    }

    @Test
    public void enteringIGivesYou1(){
        assertEquals(1, arabicConverter.numeralToNumber("I"));
    }

    //Adds logic for letters that need to be subtracted from a larger letter i.e. IX
    @Test
    public void enteringCMGivesYou900(){
        assertEquals(900, arabicConverter.numeralToNumber("CM"));
    }

    @Test
    public void enteringCDGivesYou400(){
        assertEquals(400, arabicConverter.numeralToNumber("CD"));
    }

    @Test
    public void enteringXCGivesYou90(){
        assertEquals(90, arabicConverter.numeralToNumber("XC"));
    }

    @Test
    public void enteringXLGivesYou40(){
        assertEquals(40, arabicConverter.numeralToNumber("XL"));
    }

    @Test
    public void enteringIXGivesYou9(){
        assertEquals(9, arabicConverter.numeralToNumber("IX"));
    }

    @Test
    public void enteringIVGivesYou4(){
        assertEquals(4, arabicConverter.numeralToNumber("IV"));
    }

    //Tests given by the kata/scenario
    @Test
    public void enteringMLXVIGivesYou1066(){
        assertEquals(1066, arabicConverter.numeralToNumber("MLXVI"));
    }

    @Test
    public void enteringMCMLXXXIXGivesYou1989(){
        assertEquals(1989, arabicConverter.numeralToNumber("MCMLXXXIX"));
    }

    @Test
    public void enteringMCMGivesYou1900(){
        assertEquals(1900, arabicConverter.numeralToNumber("MCM"));
    }

    //Adds tests to ensure that double letters doesn't add unwanted extra numbers
    @Test
    public void enteringMMCMXLVIGivesYou2946(){
        assertEquals(2946, arabicConverter.numeralToNumber("MMCMXLVI"));
    }

}
