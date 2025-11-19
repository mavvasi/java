package pr17zad2;

import java.util.Scanner;

public class EmployeeController {
    private Employee employee;
    private View view;
    private Scanner scanner;

    public EmployeeController(Employee employee, View view) {
        this.employee = employee;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void updateView() {
        double total = employee.calculateTotalSalary();
        view.showEmployee(employee.getName(), employee.getSalary(), total);
    }

    public void changeSalary() {
        view.showMessage("Текущая зарплата: " + employee.getSalary());
        view.showMessage("Введите новую зп:");
        double newSalary = scanner.nextDouble();
        employee.setSalary(newSalary);
        view.showMessage("Зарплата изменена");
    }

    public void addHours() {
        view.showMessage("Введите количество часов:");
        int hours = scanner.nextInt();
        employee.setHours(hours);
        view.showMessage("Часы добавлены");
    }

    public void addBonus() {
        view.showMessage("Введите размер премии:");
        double bonus = scanner.nextDouble();
        employee.setBonus(bonus);
        view.showMessage("Премия добавлена");
    }

    public void run() {
        boolean working = true;

        while(working) {
            System.out.println("\n1 - Показать информацию");
            System.out.println("2 - Изменить зарплату");
            System.out.println("3 - Добавить часы");
            System.out.println("4 - Добавить бонус");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1: updateView(); break;
                case 2: changeSalary(); break;
                case 3: addHours(); break;
                case 4: addBonus(); break;
                case 0:
                    working = false;
                    view.showMessage("До свидания");
                    break;
                default:
                    view.showError("Неверный выбор!");
            }
        }
        scanner.close();
    }
}