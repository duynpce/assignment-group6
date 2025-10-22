package Service;

import java.util.HashMap;

import Enum.Constant;

import models.Pet;

public interface PetService {
    public final String petFile = Constant.PET_FILE.getFileName();
    public static HashMap<Integer,Pet> petMap = new HashMap<>();
    
    public static void load(){
    }

    public static void save(){

    }

    public void add();
    public void remove();
    public void find();
    public void change();
    public void viewAll();
   
}
