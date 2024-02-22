package test.Vectors;

public class Vector {

    private final double[] vector;

    public Vector(Integer length) {
        vector = new double[length];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (double num : vector)
            string.append(num).append(" ");
        return string.toString();
    }

    public void add(double... args) {
        if (vector.length != args.length) {
            System.out.println("Колличество аргументов не равно длине вектора.");
        } else {
            for (int i = 0; i < vector.length; i++)
                vector[i] = args[i];
        }
    }

    public void setElement(Integer index, double num) {
        vector[index] = num;
    }

    public Object get(Integer index) {
        if (index > vector.length) {
            return null;
        }
        return vector[index];
    }

    public Integer getLength() {
        return vector.length;
    }

    public double getMinValue() {
        double min = vector[0];
        for (int i = 0; i < vector.length; i++)
            if (vector[i] < min) min = vector[i];
        return min;
    }

    public double getMaxValue() {
        double max = vector[0];
        for (int i = 0; i < vector.length; i++)
            if (vector[i] > max) max = vector[i];
        return max;
    }

    private void sort() {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j + 1] < vector[j]) {
                    double swap = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = swap;
                }
            }
        }
    }

    public double calculateNorm() {
        double sum = 0;
        for (double num : vector)
            sum += num * num;
        return Math.sqrt(sum);
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < vector.length; i++)
            vector[i] *= scalar;
    }

    public void plus(Vector other) {
        if (other.getLength() != vector.length) {
            System.out.println("У векторов разная длина");
        } else {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += (double) other.get(i);
            }
        }
    }

    public void multiply(Vector other) {
        if (other.getLength() != vector.length) {
            System.out.println("У векторов разная длина");
        } else {
            for (int i = 0; i < vector.length; i++) {
                vector[i] *= (double) other.get(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector firstVector = new Vector(5);
        Vector vectorTwo = new Vector(5);
        Vector vectorThree = new Vector(5);
        firstVector.add(1, 2, 3, 4, 5);
        vectorTwo.add(1, 1, 1, 1, 1);
        vectorThree.add(2, 2, 2, 2, 2);

        System.out.println(firstVector.toString());

        System.out.println("Нулевой элемент: " + firstVector.get(0));

        firstVector.setElement(0, 10);
        System.out.println("Нулевой элемент заменен на 10: " + firstVector.toString());

        System.out.println("Минимальное значение: " + firstVector.getMinValue());
        System.out.println("Максимальное значение: " + firstVector.getMaxValue());

        firstVector.sort();
        System.out.println("Отсортированный массив " + firstVector.toString());

        System.out.println("Евклидова норма: " + firstVector.calculateNorm());

        firstVector.multiplyByScalar(2);
        System.out.println("Вектор, умноженный на 2: " + firstVector.toString());

        firstVector.plus(vectorTwo);
        System.out.println("Вектор 1 плюс Вектор 2: " + firstVector.toString());

        firstVector.multiply(vectorThree);
        System.out.println("Вектор 1 умноженный на Вектор 3: " + firstVector.toString());
    }
}
