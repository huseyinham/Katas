package RomanNumeralsCode;

public class ArabicNumerals {

    public int numeralToNumber(String numeral) {
        char[] numeralArray = numeral.toCharArray();
        int totalNumber = 0;

        for (int counter = 0; counter < numeralArray.length; counter ++){
            if (numeralArray[counter] == 'M') {
                totalNumber += 1000;
            }

            if (numeralArray[counter] == 'D') {
                totalNumber += 500;
            }

            if (numeralArray[counter] == 'C') {
                totalNumber += 100;
            }

            if (numeralArray[counter] == 'L') {
                totalNumber += 50;
            }

            if (numeralArray[counter] == 'X') {
                totalNumber += 10;
            }

            if (numeralArray[counter] == 'V') {
                totalNumber += 5;
            }

            if (numeralArray[counter] == 'I') {
                totalNumber += 1;
            }

            for (int counterTwo = counter + 1; counterTwo < numeralArray.length; counterTwo ++) {

                if (numeralArray[counter] == 'C' && numeralArray[counterTwo] == 'M') {
                    totalNumber += 800;
                    counter += 1;
                }

                if (numeralArray[counter] == 'C' && numeralArray[counterTwo] == 'D') {
                    totalNumber += 300;
                    counter += 1;
                }

                if (numeralArray[counter] == 'X' && numeralArray[counterTwo] == 'C'){
                    totalNumber += 80;
                    counter += 1;
                }

                if (numeralArray[counter] == 'X' && numeralArray[counterTwo] == 'L'){
                    totalNumber += 30;
                    counter += 1;
                }

                if (numeralArray[counter] == 'I' && numeralArray[counterTwo] == 'X'){
                    totalNumber += 8;
                    counter += 1;
                }

                if (numeralArray[counter] == 'I' && numeralArray[counterTwo] == 'V'){
                    totalNumber += 3;
                    counter = +1;
                }

            }
        }
        return totalNumber;


    }
}