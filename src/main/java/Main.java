import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Product rice = new Product("Rice",2.70f,10);
        Product potatoes = new Product("Potatoes",1.50f,10);
        Product juice = new Product("Juice",5.00f,20);

        List<Product> products = new ArrayList<Product>();
        products.add(rice.product);
        products.add(potatoes);
        products.add(juice);

        for (Product currentProducts: products){
            System.out.println(currentProducts);
        }
        System.out.println("Welcome to the shop !Please enter your name:");
        User user1 = new User(1,scanner.nextLine(),0);
      user1.setActiveUser(user1);
        System.out.println(user1.name+ ", Please enter the value for credit:");
        String response = user1.creditUser(scanner.nextFloat());
        System.out.println("Your balance is:  "+user1.getUserBalance());
        System.out.format("Which product do you want to buy?\n %s(%f )\n%s(%f )\n%s( %f)",rice.product,rice.price,potatoes.product,potatoes.price,juice.product,juice.price);
        String choice = scanner.nextLine();
       switch (choice){
           case "rice":
           double newbalance = user1.getUserBalance()- rice.price;
               System.out.println("Your balance is:" + newbalance);
               break;
           case "potatoes":
               double newbalance2 = user1.getUserBalance()- potatoes.price;
               System.out.println("Thank you for purchase .Your balance is:" + newbalance2);
               break;
           case "juice":
               double newbalance3 = user1.getUserBalance()- juice.price;
               System.out.println("Your balance is:" + newbalance3);
               break;
       }
    }
    private static void potatoesBought() {

    }

    private static void juiceBought() {
    }


}