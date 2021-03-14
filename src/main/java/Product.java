import java.util.ArrayList;
import java.util.List;

public class Product<products> {
    public String product;
    public float price;
    public int amount;

    public double getPrice() {
        return price;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product(String product, float price, int amount) {
        this.product = product;
        this.price = price;
        this.amount = amount;
    }


}
