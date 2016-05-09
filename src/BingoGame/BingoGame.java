package BingoGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BingoGame {
    private int minPossibleBallNumber = 1;
    private int maxPossibleBallNumber = 75;
    private ArrayList<Integer> listOfPossibleNumbers = new ArrayList<Integer>(75);

    public BingoGame(){
        populateListOfPossibleNumbers();
    }

    public int callNumber() {
        int rolledNumber = ThreadLocalRandom.current().nextInt(minPossibleBallNumber, maxPossibleBallNumber + 1);
        maxPossibleBallNumber -= 1;
        return listOfPossibleNumbers.remove(rolledNumber);
    }

    private void populateListOfPossibleNumbers() {
        for (int i = 0; i < 75; i++) {
            listOfPossibleNumbers.add(i+1);
        }
    }
}
