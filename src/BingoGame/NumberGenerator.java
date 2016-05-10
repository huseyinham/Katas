package BingoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 75; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
}
