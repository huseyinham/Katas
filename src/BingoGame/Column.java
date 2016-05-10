package BingoGame;

import java.util.ArrayList;
import java.util.List;

public class Column {
    private List<Integer> numbers;
    private List<Integer> listOfPossibleNumbers;

    public Column(int min, int max, List<Integer> listOfPossibleNumbers) {
        this.listOfPossibleNumbers = listOfPossibleNumbers;
        this.numbers = getColumnNumbers(min, max);
    }


    public Integer getRowNumber(int rowNumber) {
        return numbers.get(rowNumber);
    }

    public Integer getRowCount() {
        return numbers.size();
    }

    private List<Integer> getColumnNumbers(int min, int max) {
        List<Integer> numbers = new ArrayList<>();
        for (Integer number : listOfPossibleNumbers) {
            if (number >= min && number <= max) {
                numbers.add(number);
                if (numbers.size() == 5) {
                    return numbers;
                }
            }
        }
        return numbers;
    }
}

