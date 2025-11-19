package pr20zad5;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Matrix<T extends Number> {
    private T[][] data;
    private int rows;
    private int cols;

    // Конструктор с двумерным массивом
    @SuppressWarnings("unchecked")
    public Matrix(T[][] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = (T[][]) new Number[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same length");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    // Конструктор с размерами и значением по умолчанию
    @SuppressWarnings("unchecked")
    public Matrix(int rows, int cols, T defaultValue) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = (T[][]) new Number[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = defaultValue;
            }
        }
    }

    // Геттеры
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public T get(int row, int col) {
        checkBounds(row, col);
        return data[row][col];
    }

    // Сеттер
    public void set(int row, int col, T value) {
        checkBounds(row, col);
        data[row][col] = value;
    }

    // Проверка границ
    private void checkBounds(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException(
                    String.format("Index [%d,%d] out of bounds for matrix %dx%d",
                            row, col, rows, cols));
        }
    }

    // 1. Сложение матриц
    public Matrix<T> add(Matrix<T> other) {
        checkDimensions(other);
        return elementWiseOperation(other, this::addNumbers);
    }

    // 2. Вычитание матриц
    public Matrix<T> subtract(Matrix<T> other) {
        checkDimensions(other);
        return elementWiseOperation(other, this::subtractNumbers);
    }

    // 3. Умножение матриц
    @SuppressWarnings("unchecked")
    public Matrix<T> multiply(Matrix<T> other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException(
                    "Number of columns in first matrix must equal number of rows in second matrix");
        }

        Matrix<T> result = new Matrix<>(rows, other.cols, (T) Integer.valueOf(0));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                T sum = (T) Integer.valueOf(0);
                for (int k = 0; k < cols; k++) {
                    T product = multiplyNumbers(data[i][k], other.data[k][j]);
                    sum = addNumbers(sum, product);
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    // 4. Умножение на скаляр
    public Matrix<T> scalarMultiply(T scalar) {
        Matrix<T> result = new Matrix<>(rows, cols, scalar);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = multiplyNumbers(data[i][j], scalar);
            }
        }
        return result;
    }

    // 5. Транспонирование матрицы
    @SuppressWarnings("unchecked")
    public Matrix<T> transpose() {
        Matrix<T> result = new Matrix<>(cols, rows, (T) Integer.valueOf(0));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[j][i] = data[i][j];
            }
        }
        return result;
    }

    // 6. Поэлементная операция
    private Matrix<T> elementWiseOperation(Matrix<T> other, BinaryOperator<T> operation) {
        Matrix<T> result = new Matrix<>(rows, cols, data[0][0]);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = operation.apply(data[i][j], other.data[i][j]);
            }
        }
        return result;
    }

    // 7. Применение функции к каждому элементу
    public Matrix<T> map(Function<T, T> function) {
        Matrix<T> result = new Matrix<>(rows, cols, data[0][0]);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = function.apply(data[i][j]);
            }
        }
        return result;
    }

    // 8. Вычисление определителя (только для квадратных матриц)
    @SuppressWarnings("unchecked")
    public T determinant() {
        if (rows != cols) {
            throw new UnsupportedOperationException("Determinant is defined only for square matrices");
        }

        if (rows == 1) {
            return data[0][0];
        }

        if (rows == 2) {
            T a = multiplyNumbers(data[0][0], data[1][1]);
            T b = multiplyNumbers(data[0][1], data[1][0]);
            return subtractNumbers(a, b);
        }

        // Для матриц 3x3 и больше используем разложение по первой строке
        T det = (T) Integer.valueOf(0);
        for (int j = 0; j < cols; j++) {
            Matrix<T> minor = getMinor(0, j);
            T minorDet = minor.determinant();
            T term = multiplyNumbers(data[0][j], minorDet);

            if (j % 2 == 0) {
                det = addNumbers(det, term);
            } else {
                det = subtractNumbers(det, term);
            }
        }
        return det;
    }

    // 9. Получение минора
    @SuppressWarnings("unchecked")
    private Matrix<T> getMinor(int rowToRemove, int colToRemove) {
        Matrix<T> minor = new Matrix<>(rows - 1, cols - 1, (T) Integer.valueOf(0));

        int minorRow = 0;
        for (int i = 0; i < rows; i++) {
            if (i == rowToRemove) continue;

            int minorCol = 0;
            for (int j = 0; j < cols; j++) {
                if (j == colToRemove) continue;

                minor.data[minorRow][minorCol] = data[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }

    // 10. Проверка на равенство
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Matrix<?> other = (Matrix<?>) obj;
        if (rows != other.rows || cols != other.cols) return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!data[i][j].equals(other.data[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // 11. Проверка является ли матрица квадратной
    public boolean isSquare() {
        return rows == cols;
    }

    // 12. Проверка является ли матрица единичной
    public boolean isIdentity() {
        if (!isSquare()) return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    if (!data[i][j].equals(oneValue())) return false;
                } else {
                    if (!data[i][j].equals(zeroValue())) return false;
                }
            }
        }
        return true;
    }

    // Вспомогательные методы для арифметических операций
    @SuppressWarnings("unchecked")
    private T addNumbers(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() + b.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    @SuppressWarnings("unchecked")
    private T subtractNumbers(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() - b.floatValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() - b.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    @SuppressWarnings("unchecked")
    private T multiplyNumbers(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() * b.floatValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() * b.longValue());
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    @SuppressWarnings("unchecked")
    private T zeroValue() {
        if (data[0][0] instanceof Integer) {
            return (T) Integer.valueOf(0);
        } else if (data[0][0] instanceof Double) {
            return (T) Double.valueOf(0.0);
        } else if (data[0][0] instanceof Float) {
            return (T) Float.valueOf(0.0f);
        } else if (data[0][0] instanceof Long) {
            return (T) Long.valueOf(0L);
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    @SuppressWarnings("unchecked")
    private T oneValue() {
        if (data[0][0] instanceof Integer) {
            return (T) Integer.valueOf(1);
        } else if (data[0][0] instanceof Double) {
            return (T) Double.valueOf(1.0);
        } else if (data[0][0] instanceof Float) {
            return (T) Float.valueOf(1.0f);
        } else if (data[0][0] instanceof Long) {
            return (T) Long.valueOf(1L);
        } else {
            throw new UnsupportedOperationException("Unsupported number type");
        }
    }

    private void checkDimensions(Matrix<T> other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException(
                    String.format("Matrix dimensions must match: %dx%d vs %dx%d",
                            rows, cols, other.rows, other.cols));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix ").append(rows).append("x").append(cols).append(":\n");

        for (int i = 0; i < rows; i++) {
            sb.append("[");
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%8.2f", data[i][j].doubleValue()));
                if (j < cols - 1) sb.append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}