package lanit;

/**
 * Данный абстрактный класс описывает поля, которые
 * должны наследовать коробка, мешок и стопка.
 */
public abstract class Container extends Item {
    /** Поле максимального значения объма контейнера. */
    private Integer maxInternalVolume;
    /** Поле текущего значения объма контейнера. */
    private Integer internalVolume = 0;

    /**
     * Возвращает значение максимальной вместимости контейнера.
     * @return Максимальная вместимость соответственно.
     */
    public final Integer getMaxInternalVolume() {
        return maxInternalVolume;
    }

    /**
     * Метод изменения значения максимального объёма контейнера.
     * @param maxInternalVolume Поле максимального значения объёма.
     */
    public final void setMaxInternalVolume(final Integer maxInternalVolume) {
        this.maxInternalVolume = maxInternalVolume;
    }

    /**
     * Метод, изменяющий текущее значение занятого объёма в контейнере.
     * @param internalVolume Переменная занятого объёма.
     */
    public final void setInternalVolume(final Integer internalVolume) {
        this.internalVolume = internalVolume;
    }

    /**
     *  Геттер значения занятого вутреннего объема.
     * @return Возвращает занятый объём.
     */
    public final Integer getInternalVolume() {
        return internalVolume;
    }


}
