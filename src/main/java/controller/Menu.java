package controller;

import entity.Product;
import entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    Shop shop = new Shop();

    public void menu() {
        System.out.println("Welcome to the Flower shop!");
        boolean running = true;
        while (running) {
            String cmd = Input.askString("1.Add Product  \t\t2. Buy Product\n3. Add User   \t\t4.Remove User\n5.View All Products  6.Leave Shop\nEnter command: \n");
            switch (cmd) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    sellProduct();
                    break;
                case "3":
                    newUser();
                    break;
                case "4":
                    removeUser();
                    break;
                case "5":
                    viewAllProducts();
                    break;
                case "7":
                    viewAllUsers();
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command");
            }
            this.menu();
        }
        System.out.println("Bye Bye");
    }

    private void viewAllUsers() {
        ArrayList<User> users = shop.getAllUsers();
        for (User currUsers : shop.getAllUsers()) {
            System.out.println(currUsers.name + " | "
                    + currUsers.name + "  |  " + currUsers.balance);
        }
    }

    private void removeUser() {
        System.out.println("Delete User\n");
        int userId = Integer.parseInt(Input.askString("enter User ID"));
        String message = shop.removeUser(userId);
        System.out.println(message);


    }

    private void viewAllProducts() {

        ArrayList<Product> products = shop.getAllProducts();
        for (Product currProducts : shop.getAllProducts()) {
            System.out.println(currProducts.name + " | "
                    + currProducts.getAmount() + "  |  " + currProducts.price);
        }
    }

    public void sellProduct() {

        String userEmail = Input.askString("Enter email adress:");
        for (Product product : shop.getAllProducts()) {
            System.out.println(product.name);
        }
        String nameOfProduct = Input.askString("Please choose the product:");
        Integer noOfItems = Input.askInt("How many items you buy?");

        System.out.println(shop.buyProduct(nameOfProduct, userEmail, noOfItems));
        ;
    }

    public void addProduct() {

        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        product.setName(Input.askString("Hello,please enter the product name:"));
        product.price = Input.askFloat("Please enter the product price:");
        product.amount = Input.askInt("Enter the amount:");

        product.setId(UUID.randomUUID());
        product.setRegistered(LocalDate.now());
        String msg = shop.addProduct(product);
        System.out.println(msg);

    }

    private void newUser() {

        String name = Input.askString("Hello,please enter your name:");
        String email = Input.askString("email?");
        float balance = 0f;
        Usertype type = Input.askString("Write the type(owner or buyer)").toUpperCase().equals("OWNER")
                ? Usertype.OWNER : Usertype.BUYER;
        LocalDate registered = LocalDate.now();
        User user = new User(balance, name, email, type, registered);


        System.out.println("Your balance is:  " + user.getBalance());
        String msg = shop.addUser(user);
        System.out.println(msg);
        shop.setActiveUser(user);
    }
}
