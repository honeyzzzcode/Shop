package controller;

import controller.Input;
import controller.Product;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

public class Shop {
   private static ArrayList<Product> products = new ArrayList<Product>();
private ArrayList<User> users = new ArrayList<User>();


    public void listProducts() {

    }
    public  String addProduct(Product product){
        this.products.add(product);
        return product.name +" added successfully";
    }
    public ArrayList<Product> getAllProducts(){
        return products;
    }
    public Product getSingleProduct(int productId){
        return this.products.get(productId);

    }
    public  String addUser(User newuser){
       users.add(newuser);
        return newuser.name+" added successfully";
    }
    public ArrayList<User> getUsers(){
        return users;
    }





    public static void sellProduct() {
        for (Product rec : products) {
        System.out.println(rec.name);
    }
        Product product = new Product();
        if (Input.askString("Which do you want to buy?").equalsIgnoreCase(product.name) ) {
            product.amount = product.amount-1;
        }
        System.out.println(product.name +" is sold to you and "+ product.amount + " left");;
    }

    public String removeUser(int userId) {

        try {
            users.remove(userId);
        } catch (Exception ex) {
            return "Unable to remove specified user";

        }
        return "user removed successfully";

    }
}
