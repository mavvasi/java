package zad1pr6;

public class Planet implements Nameable {
    private String name;
    private double mass; // масса в кг
    private double radius; // радиус в км

    public Planet(String name, double mass, double radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Планета '%s' (масса: %.2e кг, радиус: %.0f км)",
                name, mass, radius);
    }
}