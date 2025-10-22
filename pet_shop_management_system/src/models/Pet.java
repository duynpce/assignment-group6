package models;

import java.io.Serializable;
public abstract class Pet implements Serializable {
    private int ID;
    private int age;
    private double price;
    private String name;
    private String gender;
    
    protected Pet(){}
    protected Pet(int ID, int age,double price, String name, String gender){
        this.ID = ID;
        this.age = age;
        this.price = price;
        this.name = name;
        this.gender = gender;
    }

    public int getID(){ return ID;}
    public void setID(int ID){ this.ID = ID;}

    public int getAge(){ return age; }
    public void setAge(int age){ this.age = age; }

    public double getPrice(){ return price; }
    public void setPrice(double price){ this.price = price; }

    public String getName(){ return name; }
    public void setName(String name ){ this.name = name; }

    public String getGender(){ return gender;};
    public void setGender(String gender){ this.gender = gender;};

    public abstract String getSpecie();
    public abstract void setSpecie(String speice);


    public abstract void play();
    
    public void display(){
        System.out.println("ID : " + getID());
        System.out.println("age : " + getAge());
        System.out.println("price : " + getPrice());
        System.out.println("name : " + getName());
        System.out.println("gender : " + getGender());
        System.out.println("specie : " + getSpecie());
    }

} 
