package models;

import java.io.Serializable;
public class Transaction implements Serializable{
    private int ID;
    private double value;
    private String time;

    public Transaction(){}
    public Transaction(int ID, double value, String time){
        this.ID = ID;
        this.value = value;
        this.time = time;
    }

    
    public int getID(){ return ID; }
    public void setID(int ID){ this.ID = ID; }

    public double getValue(){ return value; }
    public void setValue(double value){ this.value = value; }

    public String getTime(){ return time; }
    public void setTime(String time){ this.time = time; }

    public void display(){
        System.out.println("transaction ID: " + ID);
        System.out.println("value: " + value);
        System.out.println("time: " + time);
    }
    
}
