package library.models;

public class Pet implements Animal  {
    private int ID;
    private int age;
    private double price;
    private String name;
    private String gender;
    private String breed;
    private String specie;
    
    public Pet(){}
    public Pet(int ID, int age,double price, String name, String gender, String breed, String specie){
        this.ID = ID;
        this.age = age;
        this.price = price;
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.specie = specie;
    }

    public int getID(){ return ID;}
    public void setID(int ID){ this.ID = ID;}

    public int getAge(){ return age; }
    public void setAge(int age){ this.age = age; }

    public double getPrice(){ return price; }
    public void setPrice(double price){ this.price = price; }

    public String getName(){ return name; }
    public void setName(String name ){ this.name = name; }

    public String getGender(){ return gender;};
    public void setGender(String gender){ this.gender = gender;};

    public String getBreed() {return breed; }
    public void setBreed(String breed){ this.breed = breed;}

    public String getSpecie(){ return specie;}
    public void setSpecie(String speice){ this.specie = speice;}
    
    public void eat(){System.out.println("eating ....");}

    public void drink(){System.out.println("drinking ....");}

    public void display(){
        System.out.println("ID : " + ID);
        System.out.println("age : " + age);
        System.out.println("price : " + price);
        System.out.println("name : " + name);
        System.out.println("gender : " + gender);
        System.out.println("breed : " + breed);
        System.out.println("specie : " + specie);
    }

    
   
}
