package lanit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;


import java.util.concurrent.TimeUnit;

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
    private static Item ball;

    @Rule
    public TestRule timeout = new Timeout(100L, TimeUnit.SECONDS);

    @Before
    public void setUp() {
        box1 = new Box("Подарочная коробка", 2.0, 1,
                "Разноцветная", 10);
        box2 = new Box("Коробка от наушников", 1, "Белая");
        box3 = new Box("Кейс", 2, "Белая");
        stack1 = new Stack("Внезапная стопка", 5);
        stack2 = new Stack("Запланированная стопка", 10);
        bag1 = new Bag("Подарочный мешок", 0.2, 5,
                "Разноцветный", 10);
        bag2 = new Bag("Мусорный мешок", 1, "Прозрачный");
        bag3 = new Bag("Сахарный мешок", 2, "Белый");
        ball = new Item("Мяч", 2.0, 3, false);
    }

    @Test
    public void Box1AddWithSuccess() throws ItemStoreException,
            ItemAlreadyPlacedException {
        box1.put(bag1);
        box1.put(bag2);
        box1.put(bag3);
        assertEquals(2.22, box1.getWeight(), 0.00001);
    }
    @Test
    public void Box1AddWithFail() throws ItemStoreException,
            ItemAlreadyPlacedException {
        box1.put(bag1);
        box1.put(bag2);
        box1.put(bag3);
        assertEquals(1, box1.getWeight(), 0.00001);
    }
    @Test
    public void Box2AddWithSuccess() throws ItemStoreException,
            ItemAlreadyPlacedException {
        box2.put(bag1);
        assertEquals(0.22, box2.getWeight(), 0.00001);
    }
    @Test
    public void Box2AddTwiceWithFail() throws ItemStoreException,
            ItemAlreadyPlacedException {
        box2.put(bag1);
        box2.put(bag1);
        assertEquals(0.22, box2.getWeight(), 0.00001);
    }
    @Test
    public void Box2AddWithFail() throws ItemStoreException,
            ItemAlreadyPlacedException {
        box2.put(bag1);
        box2.put(bag2);
        assertEquals(0.22, box2.getWeight(), 0.00001);
    }
    @Test
    public void Stack1AddWithSuccess() throws ItemStoreException,
            ItemAlreadyPlacedException {
        stack1.put(box1);
        stack1.put(ball);
        assertEquals(1, box2.getVolume(), 0.00001);
    }
    @Test
    public void Stack1TakeGetWithSuccess() throws ItemStoreException,
            ItemAlreadyPlacedException {
        stack1.put(box1);
        stack1.put(box2);
        stack1.take();
        assertEquals(1, box2.getVolume(), 0.00001);
    }
}