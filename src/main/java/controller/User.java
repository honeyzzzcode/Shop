package controller;

import types.Usertype;

import java.time.LocalDate;
import java.util.UUID;

public class User {


    public float balance;
    public String name;
    private Usertype type;
    private final LocalDate registered;
    public User(float balance, String name, Usertype type, LocalDate registered) {
        this.balance = balance;
        this.name = name;
        this.type = type;
        this.registered = registered;
    }



    public float getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public Usertype getType() {
        return type;
    }

    public LocalDate getRegistered() {
        return registered;
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
