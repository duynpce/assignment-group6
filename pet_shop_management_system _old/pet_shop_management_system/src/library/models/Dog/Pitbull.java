package library.models.Dog;

public class Pitbull extends Dog{
    
    public Pitbull(){};
    public Pitbull(int ID, int age, double price, String name, String gender){
        super(ID, age, price, name, gender, "Pitbull");
    }

    public void setBreed(){
           System.out.println("cannot change the breed becasue it's fixed to \"Pitbull\" ");
    }
}