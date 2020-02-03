package lanit;

/**
 * Класс, реализующий логику стопки объектов.
 */
public class Stack extends Container {
    /**  */
    private static final Double DEFAULT_STACK_WEIGHT = 0.0;
    private Integer maxSize;
    public java.util.Stack<Item> intoStack = new java.util.Stack<>();

    Stack(String name, Integer maxSize){
        super.setName(name);
        super.setWeight(DEFAULT_STACK_WEIGHT);
        super.setFlat(true);
        this.maxSize = maxSize;
    }

    public void put(Item item) throws ItemAlreadyPlacedException,
            ItemStoreException {
        System.out.println("Пробуем поместить на " + super.getName()
                + " " + item.getName());
        if (super.equals(item)){
            System.out.println("Не стоит помещать объект на себя.");
        } else if (!item.getFlat()){
            System.out.println("На стопку стоит помещать только плоские объекты");
        } else if (item.getUsed()){
            throw new ItemAlreadyPlacedException("Предмет уже где-то лежит");
        } else {
            if (this.getInternalVolume() + 1 <= this.maxSize) {
                this.setInternalVolume( this.getInternalVolume() + 1);
                super.setWeight(this.getWeight() + item.getWeight());
                intoStack.push(item);
                item.setUsed(true);
                System.out.println("Всё ок.");
            }else{
                throw new ItemStoreException("На стопке нет места");
            }
        }
    }

    public void take() {
        System.out.println("Убираем верхний предмет");
        if (!intoStack.empty()) {
            super.setInternalVolume( super.getInternalVolume() - 1);
            super.setWeight(this.getWeight()
                    - intoStack.lastElement().getWeight());
            System.out.println("Со стопки убран " + intoStack.lastElement());
            intoStack.pop();
        } else {
            System.out.println("Стопка была пуста");
        }
    }

    public void getInfo() {
        System.out.println("============");
        System.out.println(this.getName() + "\n" + this.getInternalVolume()
                + "\n" + this.getFlat() +
                "\n" + this.getWeight() + "\n" + "В стопке: "
                + this.getItems());
    }

    public java.util.Stack<Item> getItems() {
        return intoStack;
    }
}
