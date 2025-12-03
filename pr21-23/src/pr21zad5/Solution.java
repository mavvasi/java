package pr21zad5;
import java.util.*;

public class Solution<T, K, V> {
    // Три переменные типа
    private T genericField;
    private K keyField;
    private V valueField;

    // Конструктор, принимающий на вход три параметра
    public Solution(T genericField, K keyField, V valueField) {
        this.genericField = genericField;
        this.keyField = keyField;
        this.valueField = valueField;
    }

    // Геттеры для полей
    public T getGenericField() {
        return genericField;
    }

    public K getKeyField() {
        return keyField;
    }

    public V getValueField() {
        return valueField;
    }

    // Сеттеры для полей
    public void setGenericField(T genericField) {
        this.genericField = genericField;
    }

    public void setKeyField(K keyField) {
        this.keyField = keyField;
    }

    public void setValueField(V valueField) {
        this.valueField = valueField;
    }


    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
        if (elements == null || elements.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<T> list = new ArrayList<>(elements.length);
        Collections.addAll(list, elements);
        return list;
    }


    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... elements) {
        if (elements == null || elements.length == 0) {
            return new HashSet<>();
        }

        HashSet<T> set = new HashSet<>(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Object... keysAndValues) {
        if (keysAndValues == null || keysAndValues.length == 0) {
            return new HashMap<>();
        }

        // Проверка, что количество аргументов четное
        if (keysAndValues.length % 2 != 0) {
            throw new IllegalArgumentException(
                    "Количество аргументов должно быть четным. " +
                            "Передано: " + keysAndValues.length
            );
        }

        @SuppressWarnings("unchecked")
        HashMap<K, V> map = new HashMap<>(keysAndValues.length / 2);

        for (int i = 0; i < keysAndValues.length; i += 2) {
            @SuppressWarnings("unchecked")
            K key = (K) keysAndValues[i];
            @SuppressWarnings("unchecked")
            V value = (V) keysAndValues[i + 1];
            map.put(key, value);
        }

        return map;
    }


    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<K, V>... pairs) {
        if (pairs == null || pairs.length == 0) {
            return new HashMap<>();
        }

        HashMap<K, V> map = new HashMap<>(pairs.length);
        for (Pair<K, V> pair : pairs) {
            map.put(pair.getKey(), pair.getValue());
        }
        return map;
    }

    @Override
    public String toString() {
        return String.format("Solution{genericField=%s, keyField=%s, valueField=%s}",
                genericField, keyField, valueField);
    }
}


class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    @Override
    public String toString() {
        return String.format("Pair{%s=%s}", key, value);
    }
}