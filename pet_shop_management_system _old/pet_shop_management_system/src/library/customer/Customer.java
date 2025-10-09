package library.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Customer implements Serializable{
    private int ID;
    private int age;
    private String name;
    private String gender;
    private List <Transaction> transactionHistory = new ArrayList<>();

    public Customer(){}
    public Customer(int ID, int age, String name, String gender){
        this.ID = ID;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public int getID(){ return ID; }
    public void setID(int ID){ this.ID = ID; }

    public int getAge(){ return age; }
    public void setAge(int age){ this.age = age; }

    public String getName(){ return name; }
    public void setName(String name ){ this.name = name; }

    public String getGender(){ return gender;};
    public void setGender(String gender){ this.gender = gender;};

    public void addTransaction(Transaction transaction){
        transactionHistory.add(transaction);
    }

    public void display(){
        System.out.println("ID : " + ID);
        System.out.println("age : " + age);
        System.out.println("name : " + name);
        System.out.println("gender : " + gender);
    }

    public void displayStransactionHistory(){
        for (Transaction transaction : transactionHistory) {
            transaction.display();
            System.out.println();
        }
    }

    
}