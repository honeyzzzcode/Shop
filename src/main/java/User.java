public class User {


    public int id = 0;
    public float balance;
    public String name;


    public int getId() {
        return id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public User(int id, String name, float balance) {
        this.id = id;
        this.name = name;
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
