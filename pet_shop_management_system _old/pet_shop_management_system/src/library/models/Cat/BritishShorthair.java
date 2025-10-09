package library.models.Cat;

public class BritishShorthair extends Cat {

    public BritishShorthair(){}
    public BritishShorthair(int ID, int age, double price, String name, String gender){
        super(ID, age, price, name, gender, "BritishShorthair");
    }

    public void setBreed(){
           System.out.println("cannot change the breed becasue it's fixed to \"BritishShorthair\" ");
    }
    void hunt(){ System.out.println("huting lizard");}
}