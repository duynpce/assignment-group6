package library.function;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.HashMap;

import library.models.Pet;
import library.models.Dog.Dog;
import library.models.Cat.Cat;
public class PetService {
    public static boolean isOtherAnimal = false;
    public static boolean isCat = false;
    public static boolean isDog = false;
    private static final String petFile = "Pet.data";
    protected static HashMap <Integer, Pet> petMap = new HashMap<>();

    public static void save(){
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(petFile))){
            for (Pet pet : petMap.values()) {
             writeFile.writeObject(pet);   
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    public static void load(){
        Pet pet = new Pet();
       try(ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(petFile))){
        try{
            while(true){
            pet = (Pet) readFile.readObject();
            petMap.put(pet.getID(),pet);
            }
        }catch(EOFException error){
            }
        }catch(IOException | ClassNotFoundException error){
            // error.printStackTrace();
       }
    }
    
    public static void add(){

        
        Pet pet;
        int ID, age;
        double price;
        String name, gender, breed, specie;
        ID = Utility.enterPositiveIntWithPromt("please enter ID: ");
        if(petMap.containsKey(ID)){
            System.out.println("ID existed, add failed");
            return;
        }

        age = Utility.enterPositiveIntWithPromt("please enter age: ");
        price = Utility.enterPositiveDoubleWithPromt("please enter price: ");
        name = Utility.nextLineWithPromt("please enter name: ");
        gender = Utility.nextLineWithPromt("please enter gender: ");
        breed = Utility.nextLineWithPromt("please enter breed: ");
        
        if(isOtherAnimal) {/// if choose create other animal --> set breed and specie 
            specie = Utility.nextLineWithPromt("please enter specie: ");
            pet = new Pet(ID, age, price, name, gender, breed, specie);
        }
        else if(isDog) {
            pet = new Dog(ID, age, price, name, gender, breed);
        }
        else {
            pet = new Cat(ID, age, price, name, gender, breed);
        }

        petMap.put(pet.getID(),pet);
        System.out.println("add successfully");
    }

    public static void remove(){
        int ID = Utility.enterPositiveIntWithPromt("enter ID to remove: ");
        if(!petMap.containsKey(ID)){
            System.out.println("ID not exsited");
            return;
        }
        petMap.remove(ID);

        File currentFile = new File("tempPet.data");
        File oldFile = new File( petFile);
        try{
            currentFile.createNewFile();
        }catch(Exception error){}
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(currentFile))){
            for(Integer key : petMap.keySet()){
                if(petMap.get(key).getID() == ID) continue;
                writeFile.writeObject(petMap.get(key));
            }
        }catch(IOException error){
            error.printStackTrace();
        }

        if(oldFile.delete()){
            currentFile.renameTo(oldFile);
            System.out.println("Remove successfully");
        }
        else {
            System.out.println("can not delete file Pet.data, remove failed");
            currentFile.delete();
        }
    }

    
    public static void find(){
        int ID = Utility.enterPositiveIntWithPromt("enter ID to find: ");
        if(!petMap.containsKey(ID)){
            System.out.println("ID not exsited");
            return;
        }
        petMap.get(ID).display();

    }

    public static void change(){
        Pet pet = new Pet();
        int ID = Utility.enterPositiveIntWithPromt("enter ID to change: ");
        if(!petMap.containsKey(ID)) {
            System.out.println("ID not exsited");
            return;
        }
        File currentFile = new File("tempPet.data");
        File oldFile = new File( petFile);

        System.out.println("what do want to change ");
        System.out.println("1 ID, 2 age, 3 price, 4 name, 5 gender, 6 breed, 7 specie");
        System.out.println("enter correspond number");
        Utility.makeChoice(1, 7);
        switch (Utility.choice) {
            case 1:
                int newID = Utility.enterPositiveIntWithPromt("please enter new ID: ");
                petMap.get(ID).setID(newID);
                pet = petMap.get(ID);
                petMap.remove(ID);
                petMap.put(newID, pet);
                break;
            case 2:
                int newAge = Utility.enterPositiveIntWithPromt("please enter new Age: ");
                petMap.get(ID).setAge(newAge);
                break;
            case 3: 
                double newPrice = Utility.enterPositiveDoubleWithPromt("please enter new Price: ");
                petMap.get(ID).setPrice(newPrice);
                break;
            case 4:
                String newName = Utility.nextLineWithPromt("please enter new Name: ");
                petMap.get(ID).setName(newName);
                break;
            case 5:
                String newGender = Utility.nextLineWithPromt("please enter new Gender: ");
                petMap.get(ID).setGender(newGender);
                break;
            case 6:
                String newBreed = Utility.nextLineWithPromt("please enter new Breed: ");
                petMap.get(ID).setBreed(newBreed);
                break;
            case 7:
                String newSpecie = Utility.nextLineWithPromt("please enter new Specie: ");
                petMap.get(ID).setSpecie(newSpecie);
                break;
        }
        
        try{
            currentFile.createNewFile();
        }catch(Exception error){}
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(currentFile))){
            for(Integer key : petMap.keySet()){
                writeFile.writeObject(petMap.get(key));
            }
        }catch(IOException error){
            error.printStackTrace();
        }

        if(oldFile.delete()){
            currentFile.renameTo(oldFile);
            System.out.println("change successfully");
        }
        else {
            System.out.println("can not delete file Pet.data, change failed");
        }
    }

    public static void viewAll(){
        if(petMap.isEmpty()){
            System.out.println("no Pet existed");
            return;
        }
        for (Pet pet : petMap.values()) {
            pet.display();
            System.out.println();
        }
    }
}
