package RomanNumeralsCode;


import java.util.ArrayList;

public class RomanNumerals {

    public String numberToNumeral(int inputNumber) {
        String numeral = "";

        if(inputNumber >= 4000){
            System.out.println("Number too large.");
            return "Number too large";
        }

        while (inputNumber >= 1000){
            inputNumber -= 1000;
            numeral += "M";
        }

        while (inputNumber >= 900){
            inputNumber -= 900;
            numeral += "CM";
        }

        while (inputNumber >= 500){
            inputNumber -= 500;
            numeral += "D";
        }

        while (inputNumber >= 400) {
            inputNumber -= 400;
            numeral += "CD";
        }

        while (inputNumber >= 100){
            inputNumber -= 100;
            numeral += "C";
        }

        while (inputNumber >= 90) {
            inputNumber -= 90;
            numeral += "XC";
        }

        while (inputNumber >= 50){
            inputNumber -= 50;
            numeral += "L";
        }

        while (inputNumber >= 40) {
            inputNumber -= 40;
            numeral += "XL";
        }

        while (inputNumber >= 10){
            inputNumber -= 10;
            numeral += "X";
        }

        while (inputNumber >= 9){
            inputNumber -= 9;
            numeral += "IX";
        }

        while (inputNumber >= 5){
            inputNumber -= 5;
            numeral += "V";
        }

        while (inputNumber >= 4){
            inputNumber -= 4;
            numeral += "IV";
        }

        while (inputNumber >= 1){
            inputNumber -= 1;
            numeral += "I";
        }

        return numeral;
    }
}
