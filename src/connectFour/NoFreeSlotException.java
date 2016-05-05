package connectFour;

public class NoFreeSlotException extends RuntimeException {
    public NoFreeSlotException(String message) {
        super(message);
    }
}
