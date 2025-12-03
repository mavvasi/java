package pr21zad2;

import java.util.Arrays;

/**
 * Класс для хранения массива объектов любого типа
 */
public class GenericArrayHolder<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayHolder(Class<T> type, int size) {
        this.array = (T[]) java.lang.reflect.Array.newInstance(type, size);
    }

    public GenericArrayHolder(T[] array) {
        this.array = array;
    }

    public void set(int index, T value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
    }

    public T get(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
    }

    public T[] getArray() {
        return array;
    }

    public int length() {
        return array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}