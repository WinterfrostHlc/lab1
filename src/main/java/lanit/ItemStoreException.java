package lanit;

/**
 * Класс исключения, выбрасывающийся, если предмет не может быть помещен в
 * контейнер по причине недостатка пространства в контейнере.
 */
public class ItemStoreException extends Exception {
    /**
     * Метод без агрумента.
     */
    public ItemStoreException() {
        super();
    }

    /**
     * Метод, возвращающий текст.
     * @param message Текст сообщения.
     */
    public ItemStoreException(final String message) {
        super(message);
    }
}

