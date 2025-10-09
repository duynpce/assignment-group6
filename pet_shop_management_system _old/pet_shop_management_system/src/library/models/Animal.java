package library.models;

import java.io.Serializable;
public interface Animal extends Serializable {

    public int getID();
    public void setID(int ID);

    public int getAge();
    public void setAge(int age);

    public double getPrice();
    public void setPrice(double price);

    public String getName();
    public void setName(String name );

    public String getGender();
    public void setGender(String gender);

    public String getBreed();
    public void setBreed(String breed);

    public String getSpecie();
    public void setSpecie(String speice);
    
    public void eat();

    public void drink();

    public void display();
} 
