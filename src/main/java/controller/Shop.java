package controller;

import entity.Product;
import entity.User;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Shop {
    User user;
    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<User> users = new ArrayList<User>();

public static void FileRead(){
    var file = new File("products.txt");
    try (var in = new Scanner(file)) {
        while (in.hasNext()) {
            var prod = new Product();
            prod.setName(in.next());
            prod.setAmount(in.nextInt());
            prod.setPrice(in.nextFloat());
            products.add(prod);
        }
    } catch (FileNotFoundException e) {
        System.out.println("cannot read file");
    }
}
public void FileWrite(){
    File file = new File("products.txt");
    try (var out = new PrintWriter(file)) {
        for (var gr : products) {
            out.printf("%s %d  %s \n", gr.getName(), gr.getAmount(), gr.getPrice());
        }
    } catch (FileNotFoundException e) {
        System.out.println("cannot save file");
    }
}
    public String addProduct(Product product) {
      products.add(product);
        return product.name + " added successfully";
    }


    public ArrayList<Product> getAllProducts() {
        return products;
    }

    public Product getSingleProduct(int productId) {
        return this.products.get(productId);

    }

    public String addUser(User newUser) {
        users.add(newUser);
        return newUser.name + " added successfully";
    }

    public ArrayList<User> getUsers() {
        return users;
    }


    public String buyProduct(String productName, String userEmail, int noOfProduct) {
        Product productToSell = findProductByName(productName);
        if (productToSell == null) {
            return "product not found";
        }
        if (productToSell.getAmount() < noOfProduct) {
            return "not enough items to fulfill your order";
        }

        User buyer = findUserByEmail(userEmail);
        if (buyer == null) {
            return "user not found"; }
        float buyerBalance = buyer.getBalance();
        float totalCostOfPurchase = productToSell.getPrice()*noOfProduct;

        if (buyer.getBalance() < (totalCostOfPurchase)) {
            return "not enough balance on users account";
        }

        buyer.setBalance(buyerBalance-totalCostOfPurchase);
      productToSell.setAmount(productToSell.getAmount()-noOfProduct);



        updateUser(buyer);
        updateProduct(productToSell);
        return "Purchase succesfull";
    }

    private void updateProduct(Product productToUpdate) {
        for (Product currentProduct: this.products){

            if (currentProduct.getName().equals(productToUpdate.getName())){

                currentProduct.setAmount(productToUpdate.getAmount());
            }
        }
    }

    private void updateUser(User userToUpdate) {
        for (User currentUser: this.users){

            if (currentUser.getId().equals(userToUpdate.getId())){

                currentUser.setBalance(userToUpdate.getBalance());
            }
        }

    }

    private User findUserByEmail(String userEmail) {
        for (User currentUser : this.users) {
            if (currentUser.getEmail().toLowerCase().equals(userEmail.toLowerCase())) {
                return currentUser;
            }
        }
        return null;
    }

    private Product findProductByName(String productName) {
        for (Product currentProduct : this.getAllProducts()) {
            if (currentProduct.getName().toLowerCase().equals(productName.toLowerCase())) {
                return currentProduct;
            }

        }
        return null;
    }

    public String removeUser(int userId) {

        try {
            users.remove(userId);
        } catch (Exception ex) {
            return "Unable to remove specified user";

        }
        return "user removed successfully";

    }

    public String creditUser(float amount) {
        this.user.balance = user.balance + amount;
        return amount + " added successfully\n";

    }

    public String setActiveUser(User user) {
        this.user = user;
        return "user update successfully";
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

}

