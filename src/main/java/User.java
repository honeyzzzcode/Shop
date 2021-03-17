public class User extends Menu {


    public double id;
    public float balance;
    public String name;


    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private User user;

    public String setActiveUser(User user) {
        this.user = user;
        return "user update successfully";
    }

    public float getUserBalance() {
        return user.getBalance();
    }

    public String creditUser(float amount) {
        float newBalance = user.getBalance() + amount;
        this.user.setBalance(newBalance);
        return amount + " added successfully";
    }


}
