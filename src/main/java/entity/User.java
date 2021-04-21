package entity;

import controller.Usertype;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class User {


    public String email;


    public UUID id ;
    public float balance;
    public String name;
    private Usertype type;
    private final LocalDate registered;

    public User(float balance, String name,String email, Usertype type, LocalDate registered) {

        this.id=UUID.randomUUID();
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.type = type;
        this.registered = registered;
    }

    public UUID getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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


    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }




}
