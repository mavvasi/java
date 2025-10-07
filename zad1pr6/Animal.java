package zad1pr6;

public class Animal implements Nameable {
    private String name;
    private String species;
    private int age;
    private String habitat;

    public Animal(String name, String species, int age, String habitat) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.habitat = habitat;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return String.format("Животное '%s' (%s, возраст: %d лет, среда обитания: %s)",
                name, species, age, habitat);
    }
}
