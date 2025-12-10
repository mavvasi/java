package pr28zad4;

import java.util.Hashtable;
import java.util.Map;

class Student {
    private int number;
    private String name;
    private int age;

    public Student(int number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return number == student.number && age == student.age && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Student{number=" + number + ", name='" + name + "', age=" + age + "}";
    }
}

