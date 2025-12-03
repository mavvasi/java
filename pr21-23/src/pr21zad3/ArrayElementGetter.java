package pr21zad3;

public class ArrayElementGetter {

    /**
     * Возвращает элемент массива по индексу (для объектов)
     * @param array массив
     * @param index индекс элемента
     * @return элемент массива
     * @throws IndexOutOfBoundsException если индекс вне диапазона
     */
    public static <T> T getElement(T[] array, int index) {
        if (array == null) {
            throw new NullPointerException("Массив не может быть null");
        }
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException(
                    String.format("Индекс %d вне диапазона [0, %d]", index, array.length - 1)
            );
        }
        return array[index];
    }

    /**
     * Безопасная версия с возвратом значения по умолчанию
     */
    public static <T> T getElementSafe(T[] array, int index, T defaultValue) {
        if (array == null || index < 0 || index >= array.length) {
            return defaultValue;
        }
        return array[index];
    }
}