package models;

public class Cat extends Pet{
    private final String specie = "Cat";


    public Cat(){
        super();
    }

    public Cat(int ID, int age,double price, String name, String gender){
        super(ID, age, price, name, gender);
    }

    @Override
    public String getSpecie() {
        return specie;
    }
    public void setSpecie(String specie){
        System.out.println("cannot change the specie becasue it's fixed to \"Cat\" ");
    }

    @Override
    public void play() {
        System.out.println();           
    }
    
}
