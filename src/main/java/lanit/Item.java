package lanit;

/**
 * Класс описывает основные поля и методы, соответствующие каждому объекту,
 * который может быть создан в контексте задач, исполняемых данной программой,
 * а именно создание объектов-контейнеров и объектов без возможности содержания
 * иных предметов, но использующихся как наполнение для контейнеров.
 */
public class Item {

    /** Поле значения имени. */
    private String name;
    /** Поле веса объекта, динамически изменяется, если это контейнер. */
    private Double weight;
    /** Поле объёма, изначально инициализированный нулём, т.к. класс Стопка
     * не имеет объёма при отсутствии в ней элементов (впрочем, относительно
     * реальной логики пустая стопка тоже отсутствует, но в целях
     * демонстрирования принципов абстракции, будем считать пустую стопку
     * существующей, так как мы имеем идею о её существовании). */
    private Integer volume = 0;
    /** Флаг "плоский ли объект"?*/
    private Boolean flat;
    /** Флаг использования данного объекта в одном из контейнеров. */
    private Boolean used = false;
    Item(){}
    Item(final String name, final Double weight, final Integer volume,
         final Boolean flat){
        setName(name);
        setWeight(weight);
        setVolume(volume);
        setFlat(flat);
    }

    /**
     * Метод, позволяющий изменять значение плоскости флага.
     * True - плоский, false - нет.
     * @param flat Флаг плоскости.
     */
    public void setFlat(final Boolean flat) {
        this.flat = flat;
    }

    /**
     * Метод изменение значение объёма, которое занимает предмет сам по себе.
     * @param volume Переменная значения объёма.
     */
    public void setVolume(final Integer volume) {
        this.volume = volume;
    }

    /**
     * Метод установки веса.
     * @param weight Переменная веса.
     */
    public void setWeight(final Double weight) {
        this.weight = weight;
    }

    /**
     * Устанавливает имя.
     * @param name Параметр имени.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Метод изменения флага использован ли предмет.
     * @param used Параметр поля использования.
     */
    public void setUsed(final Boolean used) {
        this.used = used;
    }

    /**
     * Метод извлечения приватного поля имени.
     * @return Возвращает имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод извлечения значения объёма.
     * @return Возвращает внешний объём.
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * Метод извлечения веса объекта.
     * @return вес.
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Метод получения значения флага параметра плоскостьи объекта.
     * @return флаг.
     */
    public Boolean getFlat() {
        return flat;
    }

    /**
     * Метод получения значения, используется где-то этот объект или нет.
     * @return флаг.
     */
    public Boolean getUsed() {
        return used;
    }

    /**
     * Метод переопределяющий метод toString, дефолтный возвращает ссылку на
     * объект.
     * @return имя объекта.
     */
    @Override
    public String toString() {
        return getName();
    }
}
