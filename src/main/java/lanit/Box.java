package lanit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс, реализующий логику коробки, расширяющий класс контейнеров.
 */
public class Box extends Container {
    /** Поле цвета контейнера, кажется логичным, что контейнеры
     *  будут одноцветными. */
    private String color;
    /** Константа значения веса коробки без наполнения. */
    private static Double DEFAULT_BOX_WEIGHT = 0.02;
    /** Константа значения внутреннего объема коробки. */
    private static Integer DEFAULT_INTERNAL_VOLUME = 5;
    /** Коллекция для хранения всех предметов, хранящихся в данном объекте. */
    private List<Item> items = new ArrayList<>();

    /**
     * Данный конструктор коробки подробно описывает параметры коробки,
     * делая настройку более гибкой.
     * @param name Аргумент устанавливает имя мешка.
     * @param weight Аргумент устанавливает вес мешка (без наполнения).
     * @param volume Аргумент устанавливает объём мешка,
     *                    который он занимает в пространстве.
     * @param color Аргумент, указывающий цвет мешка (не java.awt.Color).
     * @param maxInternalVolume Аргумент, фиксирующий максимальный объём,
     *      *                         который мешок должен вмещать.
     */
    Box(final String name, final Double weight, final Integer volume,
        final String color, final Integer maxInternalVolume) {
        super.setName(name);
        super.setWeight(weight);
        super.setVolume(volume);
        super.setFlat(true);
        super.setMaxInternalVolume(maxInternalVolume);
        this.color = color;
    }

    /**
     * Создаёт объект коробка по упрощённой модели, более шаблонную.
     * @param name Это название коробки.
     * @param volume Это обьём коробки.
     * @param color Этоцвет коробки.
     */
    Box(final String name, final Integer volume, final String color) {
        super.setName(name);
        super.setWeight(DEFAULT_BOX_WEIGHT);
        super.setVolume(volume);
        super.setFlat(true);
        this.color = color;
        super.setMaxInternalVolume(DEFAULT_INTERNAL_VOLUME);
    }

    /**
     * Метод, реализующий логику помещения в контейнер объекта.
     * @param item Параметр item, соответственно, объект, который должен
     *             будет быть помещён в контейнер.
     */
    public void put(final Item item) throws ItemAlreadyPlacedException,
            ItemStoreException {
        System.out.println("Пробуем поместить в " + super.getName()
                + " " + item.getName());
        if (super.equals(item)) {
            System.out.println("Не стоит помещать объект внутрь себя.");
        } else if (item.getUsed()) {
            throw new ItemAlreadyPlacedException("Предмет уже где-то лежит");
        } else {
            if (this.getInternalVolume() + item.getVolume() <= this.getMaxInternalVolume()) {
                this.setInternalVolume(this.getInternalVolume() + item.getVolume());
                super.setWeight(this.getWeight() + item.getWeight());
                items.add(item);
                item.setUsed(true);
                System.out.println("Всё ок.");
            } else {
                throw new ItemStoreException("Невозможно поместить"); //hello
            }
        }
    }

    /**
     * Метод без аргумента случайным образом выбирает,
     * какой объект будет убран из коллекции.
     */
    public void take() {
        if (items.size() > 0) {
            int i = (int) (Math.random() * (items.size() - 1));
            this.setInternalVolume(this.getInternalVolume()
                    - items.get(i).getVolume());
            super.setWeight(this.getWeight() - items.get(i).getWeight());
            System.out.println("Из контейнера убран " + items.get(i).getName());
            items.get(i).setUsed(false);
            items.remove(i);
        }
    }

    /**
     * Метод, позволяющий убирать из коллекции предметы
     * и реализуется итератором.
     * @param item Предмет, который мы хотим убрать.
     */
    public void take(final Item item) {
        System.out.println("Это предмет");
        Iterator<Item> iteration = items.iterator();
        while (iteration.hasNext()) {
            if (iteration.next().equals(item)) {
                this.setInternalVolume(this.getInternalVolume()
                        - item.getVolume());
                super.setWeight(this.getWeight() - item.getWeight());
                System.out.println("Удалён предмет " + item.getName());
                item.setUsed(false);
                iteration.remove();
                return;
            }
        }
        System.out.println("Этого предмета нет в контейнере");
    }

    /**
     * Метод, который удаляет мешки из коллекции алгоритмом перебора foreach.
     * @param item Предмет, который мы ищем.
     */
    public void take(final Bag item) {
        int i = 0;
        if (items.size() > 0) {
            for (Item x : items) {
                if (x.equals(item)) {
                    i = items.indexOf(x);
                }
            }
            System.out.println("Удалён мешок " + items.get(i).getName());
            items.get(i).setUsed(false);
            items.remove(i);
        } else {
            System.out.println("Этого предмета нет в контейнере");
        }
    }

    /**
     * Метод, который убирает из коллекции стопки. реализуется логикой stream
     * api.
     * @param item Предмет, который будет убран из коллекции.
     */
    public void take(final Stack item) {
        System.out.println("Это стек");

        items.stream().filter(i -> i.equals(item)).findAny().map(p -> {
            System.out.println("Удалена стопка " + p);
            p.setUsed(false);
            return items.remove(p); });
    }

    /**
     * Метод, который лямбда выражением ищет предмет в коллекции и удаляет его.
     * @param item Предмет, который ищетсяв коллекции.
     */
    public void take(final Box item) {
        System.out.println("Это лямбда выражение");
        items.removeIf(i -> i.equals(item));
    }

    /**
     * Метод, вызов которого отображает в консоли значение полей переменных.
     */
    public void getInfo() {
        System.out.println("============");
        System.out.println(this.getName() + "\n"
                + this.getInternalVolume() + "\n" + this.getFlat()
                + "\n" + this.getWeight() + "\n" + "В коробке: "
                + this.getItems());
    }
    /**
     * Метод, возвращающий содержание коллекции.
     * @return Соответственно, возвращает содержимое.
     */
    public List<Item> getItems() {
        return items;
    }
}
