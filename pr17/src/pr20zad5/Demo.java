package pr20zad5;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ С МАТРИЦАМИ ===\n");

        // Создание матриц Integer
        Integer[][] intData1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Integer[][] intData2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        Matrix<Integer> intMatrix1 = new Matrix<>(intData1);
        Matrix<Integer> intMatrix2 = new Matrix<>(intData2);

        System.out.println("Матрица 1:");
        System.out.println(intMatrix1);

        System.out.println("Матрица 2:");
        System.out.println(intMatrix2);

        // Сложение
        System.out.println("Сложение матриц:");
        Matrix<Integer> sum = intMatrix1.add(intMatrix2);
        System.out.println(sum);

        // Вычитание
        System.out.println("Вычитание матриц:");
        Matrix<Integer> diff = intMatrix1.subtract(intMatrix2);
        System.out.println(diff);

        // Умножение матриц
        Integer[][] aData = {
                {1, 2},
                {3, 4}
        };

        Integer[][] bData = {
                {2, 0},
                {1, 2}
        };

        Matrix<Integer> a = new Matrix<>(aData);
        Matrix<Integer> b = new Matrix<>(bData);

        System.out.println("Умножение матриц:");
        System.out.println("Матрица A:");
        System.out.println(a);
        System.out.println("Матрица B:");
        System.out.println(b);
        System.out.println("A * B:");
        Matrix<Integer> product = a.multiply(b);
        System.out.println(product);

        // Умножение на скаляр
        System.out.println("Умножение матрицы на скаляр (2):");
        Matrix<Integer> scaled = a.scalarMultiply(2);
        System.out.println(scaled);

        // Транспонирование
        System.out.println("Транспонирование матрицы:");
        Matrix<Integer> transposed = a.transpose();
        System.out.println(transposed);

        // Определитель
        Integer[][] squareData = {
                {4, 7},
                {2, 6}
        };

        Matrix<Integer> squareMatrix = new Matrix<>(squareData);
        System.out.println("Квадратная матрица:");
        System.out.println(squareMatrix);
        System.out.println("Определитель: " + squareMatrix.determinant());

        // Работа с Double матрицами
        Double[][] doubleData1 = {
                {1.5, 2.5},
                {3.5, 4.5}
        };

        Double[][] doubleData2 = {
                {0.5, 1.5},
                {2.5, 3.5}
        };

        Matrix<Double> doubleMatrix1 = new Matrix<>(doubleData1);
        Matrix<Double> doubleMatrix2 = new Matrix<>(doubleData2);

        System.out.println("Double матрица 1:");
        System.out.println(doubleMatrix1);
        System.out.println("Double матрица 2:");
        System.out.println(doubleMatrix2);

        System.out.println("Сложение Double матриц:");
        Matrix<Double> doubleSum = doubleMatrix1.add(doubleMatrix2);
        System.out.println(doubleSum);

        // Применение функции
        System.out.println("Применение функции (умножение на 2):");
        Matrix<Double> mapped = doubleMatrix1.map(x -> x * 2);
        System.out.println(mapped);

        // Проверка на единичную матрицу
        Integer[][] identityData = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        Matrix<Integer> identityMatrix = new Matrix<>(identityData);
        System.out.println("Единичная матрица:");
        System.out.println(identityMatrix);
        System.out.println("Является единичной: " + identityMatrix.isIdentity());
        System.out.println("Является квадратной: " + identityMatrix.isSquare());
    }
}