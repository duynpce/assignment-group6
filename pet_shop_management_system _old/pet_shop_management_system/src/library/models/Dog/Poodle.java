package library.models.Dog;

public class Poodle extends Dog {
    
    public Poodle(){}
    public Poodle(int ID, int age, double price, String name, String gender){
        super(ID, age, price, name, gender, "Poodle");
    }

    public void setBreed(){
           System.out.println("cannot change the breed becasue it's fixed to \"Poodle\" ");
    }

}
