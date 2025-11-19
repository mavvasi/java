package pr20zad1_3;

import java.io.Serializable;

// Базовый класс Animal
class Animal implements Serializable {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', age=" + age + "}";
    }
}

// Конкретная реализация Animal
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "Dog{name='" + getName() + "', age=" + getAge() + ", breed='" + breed + "'}";
    }
}

class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cat{name='" + getName() + "', age=" + getAge() + ", color='" + color + "'}";
    }
}