package pr24zad1;

public class ComplexNumberTest {

    // 1. Класс Complex
    static class Complex {
        private int real;
        private int imaginary;

        // Конструктор без параметров
        public Complex() {
            this.real = 0;
            this.imaginary = 0;
        }

        // Конструктор с параметрами
        public Complex(int real, int imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public int getReal() {
            return real;
        }

        public int getImaginary() {
            return imaginary;
        }

        @Override
        public String toString() {
            // Красивое форматирование
            if (imaginary >= 0) {
                return real + " + " + imaginary + "i";
            } else {
                return real + " - " + Math.abs(imaginary) + "i";
            }
        }
    }

    // 2. Интерфейс Abstract Factory (точно по UML)
    interface ComplexAbstractFactory {
        Complex createComplex();                    // без параметров
        Complex CreateComplex(int real, int imaginary); // с параметрами (с большой C!)
    }

    // 3. Конкретная фабрика
    static class ConcreteFactory implements ComplexAbstractFactory {
        @Override
        public Complex createComplex() {
            return new Complex();  // вызывает конструктор без параметров
        }

        @Override
        public Complex CreateComplex(int real, int imaginary) {
            return new Complex(real, imaginary);  // вызывает конструктор с параметрами
        }
    }

    // 4. Главный метод для тестирования
    public static void main(String[] args) {
        System.out.println("=== Практическая работа 24. Задание 1 ===\n");
        System.out.println("Реализация Abstract Factory для комплексных чисел\n");

        // Создаем фабрику
        ComplexAbstractFactory factory = new ConcreteFactory();

        // Демонстрация работы
        System.out.println("1. Создание комплексных чисел разными способами:");

        // Способ 1: Через метод без параметров
        Complex c1 = factory.createComplex();
        System.out.println("   factory.createComplex() -> " + c1);

        // Способ 2: Через метод с параметрами
        Complex c2 = factory.CreateComplex(3, 4);
        System.out.println("   factory.CreateComplex(3, 4) -> " + c2);

        Complex c3 = factory.CreateComplex(-2, -5);
        System.out.println("   factory.CreateComplex(-2, -5) -> " + c3);

        Complex c4 = factory.CreateComplex(7, -2);
        System.out.println("   factory.CreateComplex(7, -2) -> " + c4);

        // Проверка значений
        System.out.println("\n2. Проверка значений:");
        System.out.println("   c2.getReal() = " + c2.getReal());
        System.out.println("   c2.getImaginary() = " + c2.getImaginary());
        System.out.println("   c3.getReal() = " + c3.getReal());
        System.out.println("   c3.getImaginary() = " + c3.getImaginary());

        // Математические примеры
        System.out.println("\n3. Математические примеры:");

        // Сумма комплексных чисел
        System.out.println("   (" + c2 + ") + (" + c4 + ") = " +
                (c2.getReal() + c4.getReal()) + " + " +
                (c2.getImaginary() + c4.getImaginary()) + "i");

        System.out.println("\n=== Задание выполнено успешно! ===");
    }
}