public class AnyException extends RuntimeException {
    private boolean flagIn;

    public boolean isFlagIn() {
        return flagIn;
    }

    public AnyException(String message, boolean flagIn) {
        super(message);
        this.flagIn=flagIn;
    }
}
