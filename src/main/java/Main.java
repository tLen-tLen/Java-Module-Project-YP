import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int countPersons = getCountPersons();
        Calculator calculator = getCalculatorWithProducts();
        calculator.showProducts();
        calculator.showScore(countPersons);
    }

    private static int getCountPersons() {
        int countPersons = 0;

        do {
            System.out.println("На скольких человек нужно разделить счет?");

            try {
                Scanner scanner = new Scanner(System.in);
                countPersons = scanner.nextInt();
                if (countPersons <= 1) {
                    System.out.println("Количество человек должно быть больше одного");
                }
            } catch (Exception e) {
                System.out.println("Некорректное количество человек");
            }
        } while(countPersons <= 1);

        return countPersons;
    }

    private static Calculator getCalculatorWithProducts() {
        Calculator calculator = new Calculator();

        do {
            String name = getProductName();
            double price = getProductPrice();
            calculator.addProduct(new Product(name, price));
        } while (!isExist());

        return calculator;
    }

    private static String getProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара");

        return scanner.next();
    }

    private static double getProductPrice() {
        double price = 0;
        while (price <= 0) {
            try {
                System.out.println("Введите стоимость товара");
                Scanner scanner = new Scanner(System.in);
                price = scanner.nextDouble();
                if (price <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Некорректная стоимость товара");
            }
        }

        return price;
    }

    private static boolean isExist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выхода введите 'завершить'. Для продолжения - введите любой символ");
        String action = scanner.next();

        return action.equalsIgnoreCase("завершить");
    }
}