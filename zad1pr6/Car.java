package zad1pr6;

public class Car implements Nameable {
    private String name;
    private String brand;
    private int year;
    private double engineVolume;

    public Car(String name, String brand, int year, double engineVolume) {
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.engineVolume = engineVolume;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public String toString() {
        return String.format("Автомобиль '%s' (%s, %d год, объем двигателя: %.1f л)",
                name, brand, year, engineVolume);
    }
}