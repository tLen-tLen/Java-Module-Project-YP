import java.util.ArrayList;

public class Calculator {
    private ArrayList<Product> products;

    public Calculator() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void showProducts() {
        System.out.println("Добавленные товары:");
        for (int i = 0; i < this.products.size(); i++) {
            Product product = this.products.get(i);
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    public void showScore(int countPersons) {
        double sum = 0;
        for (int i = 0; i < this.products.size(); i++) {
            sum += this.products.get(i).getPrice();
        }

        RusCurrencyHelper helper = new RusCurrencyHelper();

        System.out.println("\n Общая сумма: " + String.format("%.2f", sum) + helper.getCurrencyString(sum));
        double sumForOne = sum / countPersons;
        System.out.println("\n С человека: " + String.format("%.2f", sumForOne) + helper.getCurrencyString(sumForOne));
    }
}
