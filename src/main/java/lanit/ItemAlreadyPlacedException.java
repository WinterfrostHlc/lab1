package lanit;

/**
 * Класс исключения, выбрасывающийся при условии, если предмет находится в
 * ином контейнере.
 */
public final class ItemAlreadyPlacedException extends Exception {
    /**
     * Метод без агрумента.
     */
    public ItemAlreadyPlacedException() {
        super();
    }

    /**
     * Метод, возвращающий текст.
     * @param message Текст сообщения.
     */
    public ItemAlreadyPlacedException(final String message) {
        super(message);
    }
}
