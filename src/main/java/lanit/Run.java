package lanit;

/**
 * Основной класс, в котором мы прописываем все действия с объектами.
 */
final class Run {
    /**
     * Пустой конструктор Run.
     */
    private Run() { };

    /**
     * Основной метод, инициализирующий программу и переводящий код в строки,
     * доступные для терминала.
     * @param args  массив строк.
     */
    public static void main(final String[] args) throws ItemStoreExeption,
            ItemAlreadyPlacedException {

        Box box = new Box("Коробка1", 4, "Красный");
        Box box1 = new Box("Коробка2", 0.5,
                5, "Желтый", 10);
        Bag bag1 = new Bag("Мешок1", 1, "Красный");
        Bag bag3 = new Bag("Мешок_bug", 1, "Красный");
        Bag bag2 = new Bag("Мешок2", 0.05, 1,
                "Чёрный", 12);
        Stack stack1 = new Stack("Стопка журналов", 100);

        Item ball = new Item("Мяч", 2.0, 3, false);

        box1.getInfo();

        box1.put(bag1);
        box1.getInfo();

        box1.put(bag3);
        box1.getInfo();

        box1.put(bag2);
        box1.getInfo();

        box1.put(ball);
        box1.getInfo();

        System.out.println(0.5+0.01+0.01+0.05+2.0);
        System.out.println(0.5 + bag1.getWeight()+bag3.getWeight()+bag2.getWeight()+ball.getWeight());

    }
}
