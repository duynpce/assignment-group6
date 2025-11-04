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

        if(!gender.equals("Male") && !gender.equals("Female")) return;
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
    public void setGender(String gender){
        if(!gender.equals("Male") && !gender.equals("Female")) return;
        this.gender = gender;
    };

    public abstract String getSpecie();
    public abstract void setSpecie(String speice);


    public abstract void play();
    
    public void display(){
        System.out.println("ID : " + getID());
        System.out.println("Age : " + getAge());
        System.out.println("Price : " + getPrice());
        System.out.println("Name : " + getName());
        System.out.println("Gender : " + getGender());
        System.out.println("Specie : " + getSpecie());
    }
    @Override
    public String toString() {
        return "ID=" + ID +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Price=" + price +
                ", Gender='" + gender + '\'';
    }

} 
