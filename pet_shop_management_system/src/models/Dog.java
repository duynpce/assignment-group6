package models;

public class Dog extends Pet {
    private final String specie = "Dog";

    public Dog() {
        super();
    }

    public Dog(int ID, int age, double price, String name, String gender) {
        super(ID, age, price, name, gender);
    }

    @Override
    public String getSpecie() {
        return specie;
    }

    @Override
    public void setSpecie(String specie) {
        System.out.println("Cannot change the specie because it's fixed to \"Dog\".");
    }

    @Override
    public void play() {
        System.out.println("The dog is playing fetch.");
    }
}
