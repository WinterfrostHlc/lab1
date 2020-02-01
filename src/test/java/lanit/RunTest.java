package lanit;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class RunTest {
    private static Box box1;
    private static Box box2;
    private static Item box3;
    private static Stack stack1;
    private static Item stack2;
    private static Bag bag1;
    private static Bag bag2;
    private static Item bag3;

    @Before
    public void setUp() throws ItemStoreExeption, ItemAlreadyPlacedException {
        box1 = new Box("Подарочная коробка", 2.0, 1, "Разноцветная", 10);
        box2 = new Box("Коробка от наушников", 1, "Белая");
        box3 = new Box("Кейс", 2, "Белая");
        stack1 = new Stack("Внезапная стопка", 5);
        stack2 = new Stack("Запланированная стопка", 10);
        bag1 = new Bag("Подарочный мешок", 0.2, 5, "Разноцветный", 10);
        bag2 = new Bag("Мусорный мешок", 1, "Прозрачный");
        bag3 = new Bag("Сахарный мешок", 2, "Белый");

        box1.put(bag1);
        box1.put(bag2);
        box1.put(bag3);

    }

    @Test
    public void testingName() {

        assertEquals("Подарочная коробка", box1.getName());
    }
    /*
    @Test
    public void testingWeight() {
        assertEquals(2.22, box1.getWeight());
    }

     */


}