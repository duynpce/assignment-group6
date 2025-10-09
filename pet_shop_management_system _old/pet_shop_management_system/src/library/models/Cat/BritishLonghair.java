package library.models.Cat;

public class BritishLonghair extends Cat {
    
    public BritishLonghair(){}
    public BritishLonghair(int ID, int age, double price, String name, String gender){
        super(ID, age, price, name, gender, "BritishLonghair");
    }

    public void setBreed(){
           System.out.println("cannot change the breed becasue it's fixed to \"BritishLonghair\" ");
    }
    void hunt(){ System.out.println("hunting bugs");}    
}