// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите коэффициенты a, b и c через пробел:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        if (a == 0) {
            if (b == 0 && c == 0) {
                System.out.println("Коэффициенты не могут быть все равны нулю. Введите другие значения.");
            } else if (b == 0) {
                System.out.println("Уравнение не имеет решений, так как b должно быть отлично от нуля.");
            } else {
                double x = -c / b;
                System.out.println("Решение уравнения: " + x);
            }
        } else {
            double discriminant = Math.pow(b, 2) - 4 * a * c;
            if (discriminant < 0) System.out.println("Уравнение имеет комплексные решения.");
            else if (discriminant == 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Два совпадающих решения: " + x1);
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                if (x1 > x2) {
                    System.out.println("Решения: " + x2 + " и " + x1);
                } else {
                    System.out.println("Решения: " + x1 + " и " + x2);
                }
            }
        }
    }
}