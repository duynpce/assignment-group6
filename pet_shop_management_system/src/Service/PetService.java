package Service;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

   public static void save() {
    try (ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(petFile))) {
        for (Pet pet : petMap.values()) {
            writeFile.writeObject(pet);
        }
        /// ensure all infor is written
        writeFile.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void add();
    public void remove();
    public void find();
    public void change();
    public void viewAll();
   
}
