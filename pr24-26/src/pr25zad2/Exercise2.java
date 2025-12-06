package pr25zad2;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Интерфейс нашего собственного List
interface MyList<T> extends Iterable<T> {
    void add(T element);
    T get(int index);
    int size();
    void remove(int index);
}

// Наша реализация списка на основе массива
class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Внутренний класс итератора
    private class MyListIterator implements Iterator<T> {
        private int currentIndex = 0;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            canRemove = true;
            return (T) elements[currentIndex++];
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("Cannot remove element before calling next()");
            }
            MyArrayList.this.remove(--currentIndex);
            canRemove = false;
        }
    }
}

// Тестирование нашего списка и итератора
public class Exercise2 {
    public static void main(String[] args) {
        MyList<String> myList = new MyArrayList<>();

        // Добавляем элементы
        myList.add("Java");
        myList.add("Python");
        myList.add("C++");
        myList.add("JavaScript");
        myList.add("Go");

        System.out.println("Содержимое списка через итератор:");
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nСодержимое списка через for-each (реализует Iterable):");
        for (String language : myList) {
            System.out.println(language);
        }

        // Демонстрация удаления через итератор
        System.out.println("\nУдаление элементов через итератор:");
        iterator = myList.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("C++")) {
                iterator.remove();
                System.out.println("Удален: " + element);
            }
        }

        System.out.println("\nСписок после удаления:");
        for (String language : myList) {
            System.out.println(language);
        }
        System.out.println("\nРазмер списка: " + myList.size());
    }
}