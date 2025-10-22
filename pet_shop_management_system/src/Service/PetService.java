package Service;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import Enum.Constant;

import models.Pet;

public interface PetService {
    public final String petFile = Constant.PET_FILE.getFileName();
    public static HashMap<Integer,Pet> petMap = new HashMap<>();
    
    public static void load(){
        Pet pet;
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

    public static void save(){

    }

    public void add();
    public void remove();
    public void find();
    public void change();
    public void viewAll();
   
}
