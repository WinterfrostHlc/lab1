package lanit;

/**
 * Класс, реализующий логику стопки объектов.
 */
public class Stack extends Container {
    /** Поле, значение которой будет равняться количеству предметов, сколько
     * их может поместиться в данной стопке.*/
    private Integer maxSize;
    /**   Коллекция предметов, которые помещены в стопку.  */
    private java.util.Stack<Item> intoStack = new java.util.Stack<>();

    /**
     * Конструктор стопки как объекта.
     * @param name Название у стопки без содержимого абсурдно, но почему бы и
     *            нет.
     * @param maxSize Максимальный размер, ограничивающий количество объектов
     *               в стопке.
     */
    Stack(final String name, final Integer maxSize) {
        super.setName(name);
        Double defaultStackWeight = 0.0;
        super.setWeight(defaultStackWeight);
        super.setFlat(true);
        this.maxSize = maxSize;
    }

    /**
     * Метод, проверяющий, может ли объект быть помещён на стопку и, в случае
     * успеха, помещает его в коллекцию, изменяя параметры стопки.
     * @param item Объект, который мы помещаем сверху стопки.
     * @throws ItemStoreException Проброс перегрузки объёма.
     * @throws ItemAlreadyPlacedException Проброс повторного помещения объекта.
     */
    public final void put(final Item item) throws ItemAlreadyPlacedException,
            ItemStoreException {
        System.out.println("Пробуем поместить на " + super.getName()
                + " " + item.getName());
        if (super.equals(item)) {
            System.out.println("Не стоит помещать объект на себя.");
        } else if (!item.getFlat()) {
            System.out.println("На стопку стоит помещать только"
                    + " плоские объекты");
        } else if (item.getUsed()) {
            throw new ItemAlreadyPlacedException("Предмет уже где-то лежит");
        } else {
            if (this.getInternalVolume() + 1 <= this.maxSize) {
                this.setInternalVolume(this.getInternalVolume() + 1);
                super.setWeight(this.getWeight() + item.getWeight());
                intoStack.push(item);
                item.setUsed(true);
                System.out.println("Всё ок.");
            } else {
                throw new ItemStoreException("На стопке нет места");
            }
        }
    }

    /**
     * Метод, убирающий верхний объект со стопки. Реализуется как стек.
     */
    public final void take() {
        System.out.println("Убираем верхний предмет");
        if (!intoStack.empty()) {
            super.setInternalVolume(super.getInternalVolume() - 1);
            super.setWeight(this.getWeight()
                    - intoStack.lastElement().getWeight());
            System.out.println("Со стопки убран " + intoStack.lastElement());
            intoStack.pop();
        } else {
            System.out.println("Стопка была пуста");
        }
    }

    /**
     * Метод, возвращающий описание стопки.
     */
    public final void getInfo() {
        System.out.println("============");
        System.out.println(this.getName() + "\n" + this.getInternalVolume()
                + "\n" + this.getFlat()
                + "\n" + this.getWeight() + "\n" + "В стопке: "
                + this.getItems());
    }

    /**
     * Метод, позволяющий вернуть список предметов, содержащихся в стопке.
     * @return Каждый предмет.
     */
    public final java.util.Stack<Item> getItems() {
        return intoStack;
    }

}
