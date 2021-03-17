import java.util.Scanner;

public class Menu {


    public void menu(){
    boolean running = true;
        while (running) {
        String cmd = Input.askString("1. New Product\n2. Buy Product\n3. Add User or 4.Exit\nEnter command: \n");
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
                running = false;
                break;
            default:
                System.out.println("Unknown command");
        }
    }
        System.out.println("Bye Bye");
}
    public static void sellProduct() {

        Shop shop = new Shop();
        shop.sellProduct(product)
    }

    public static void addProduct() {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        product.product = Input.askString("Hello,please enter the product name:");
        product.price = Input.askFloat("Please enter the product price:");
        product.amount = Input.askInt("Enter the amount:");
        String msg = shop.addProduct(product);
        System.out.println(msg);

    }

    public static void newUser() {
        Shop shop = new Shop();
      User user = new User();
      user.id =Math.random();
        user.name = Input.askString("Hello,please enter your name:");
        user.setActiveUser(user);
        System.out.println(user.name+ ", Please enter the value for credit:");
        String response = user.creditUser(Input.askFloat(" "));
        System.out.println("Your balance is:  "+user.getUserBalance());
        String msg = shop.addUser(user);
        System.out.println(msg);
    }
}
