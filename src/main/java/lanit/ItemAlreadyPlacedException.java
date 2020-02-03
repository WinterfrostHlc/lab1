package lanit;

public class ItemAlreadyPlacedException extends Exception {

    public ItemAlreadyPlacedException() {
        super();
    }
    public ItemAlreadyPlacedException(String message) {
        super(message);
    }
}
