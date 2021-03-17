import java.util.ArrayList;
import java.util.List;

public class Shop {
   private ArrayList<Product> products = new ArrayList<Product>();
private ArrayList<User> users = new ArrayList<User>();
    public void listProducts() {
        for (Product rec : products) {
            System.out.println(rec);
        }
    }
    public String addProduct(Product product){
        this.products.add(product);
        return product.product+" added successfully";
    }
    public ArrayList<Product> getAllProducts(){
        return products;
    }
    public Product getSingleProduct(int productId){
        return this.products.get(productId);

    }
    public String addUser(User user){
        this.users.add(user);
        return user.name+" added successfully";
    }
    public String sellProduct(Product product ){

        return product.product +"is sold to you";
    }

}
