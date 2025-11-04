package models;
import java.io.Serializable;

public class OtherPet extends Pet implements Serializable {
    private String specie;

    public OtherPet() {
        super();
    }

    public OtherPet(int ID, int age, double price, String name, String gender, String specie) {
        super(ID, age, price, name, gender);
        this.specie = specie;
    }

    @Override
    public String getSpecie() {
        return specie;
    }

    @Override
    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public void play() {
        System.out.println("The pet is playing.");
    }
    @Override
    public String toString() {

        return "OtherPet[" + super.toString() + ", Specie='" + specie + "']";
    }
}
