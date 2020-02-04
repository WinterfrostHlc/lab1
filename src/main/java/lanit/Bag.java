package lanit;

/** Класс, реализующий логику мешка. Наследуется
   от коробки и копирует её поведение. */
public class Bag extends Box {

    /**
     * Расширенный конструктор создания объекта "мешок".
     * Разница с box лишь в параметре flat.
     * @param name Аргумент устанавливает имя мешка.
     * @param weight Аргумент устанавливает вес мешка (без наполнения).
     * @param volume Аргумент устанавливает объём мешка,
    который он занимает в пространстве.
     * @param color Аргумент, указывающий цвет мешка (не java.awt.Color).
     * @param maxInternalVolume Аргумент, фиксирующий максимальный объём,
     *                         который мешок должен вмещать.
     */
    Bag(final String name, final Double weight, final Integer volume,
        final String color, final Integer maxInternalVolume) {
        super(name, weight, volume, color, maxInternalVolume);
        super.setFlat(false);
    }

    /**
     * Второй конструктор сумки, нужен для описания более
      стандартизированного объекта.
     * @param name Аргумент устанавливает имя мешка.
     * @param volume Аргумент устанавливает объём мешка,
     *              который он занимает в пространстве.
     * @param color Аргумент, указывающий цвет мешка (не java.awt.Color).
     */
    Bag(final String name, final Integer volume, final String color) {
        super(name, volume, color);
        final Double defaultBagWeight = 0.01;
        super.setWeight(defaultBagWeight);
        super.setFlat(false);
        final Integer defaultInternalVolume = 6;
        this.setMaxInternalVolume(defaultInternalVolume);
    }
}
