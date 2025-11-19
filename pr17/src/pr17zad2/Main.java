package pr17zad2;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Иван Иванов", 50000); //сотрудник

        View view = new View();
        EmployeeController controller = new EmployeeController(employee, view);

        controller.run(); //для запуска
    }
}