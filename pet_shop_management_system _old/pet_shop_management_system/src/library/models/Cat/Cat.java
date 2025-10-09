package library.models.Cat;

import library.models.Pet;
public class Cat extends Pet{

    public Cat(){
        super();
    }
   
    public Cat(int ID, int age,double price, String name, String gender, String breed){
        super(ID, age, price, name, gender, breed, "Cat");
    }

    protected void play(){System.out.println("it's chasing the laser");}
    
    void setSpecie(){
        System.out.println("cannot change specie of Cat becasue it's fixed to \"Cat\" ");
    }
    
}
