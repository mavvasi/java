package pr17zad2;

public class Employee {
    private String name;
    private double salary;
    private int hours;
    private double bonus;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hours = 0;
        this.bonus = 0;
    }

    //Геттеры
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public int getHours() { return hours; }
    public double getBonus() { return bonus; }

    //Сеттеры
    public void setSalary(double salary) { this.salary = salary; }
    public void setHours(int hours) { this.hours = hours; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    //Расчет зарплаты
    public double calculateTotalSalary() {
        double hourPay = hours * 500; // 500 руб в час
        return salary + bonus + hourPay;
    }
}