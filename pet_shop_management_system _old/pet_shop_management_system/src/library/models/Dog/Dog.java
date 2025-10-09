package library.models.Dog;

import library.models.Pet;

public  class Dog extends Pet {

    public Dog(){ 
        super();
    }

    public Dog(int id, int age, double price, String name, String gender, String breed){
        super(id, age, price, name, gender, breed,"Dog");
    }


    void setSpecie(){
        System.out.println("cannot change the specie becasue it's fixed to \"Dog\" ");
    }

    public void play(){System.out.println("it's chasing the ball");}

    public void waggyTail(){System.out.println("it's wagging its tail");}

}
