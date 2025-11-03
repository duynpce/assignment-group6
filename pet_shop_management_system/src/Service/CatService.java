package Service;

import java.util.Map;
import models.Cat;
import models.Pet;
import Utility.Util;

public class CatService implements PetService{
    private static CatService catService;

     private CatService() {
    }


    public static CatService getInstance(){
        if(catService == null) {
            catService = new CatService();
        }
        return catService;
    }
    
    @Override
    public void add() {
        System.out.println("--- Add New Cat ---");
        int id = Util.enterPositiveIntWithPromt("Enter Cat ID: ");
        if (petMap.containsKey(id)){
            System.out.println("A cat with this ID already exists!");
            return;
        }
        String name = Util.nextLineWithPromt("Enter Cat Name: ");
        int age = Util.enterPositiveIntWithPromt("Enter Cat Age: ");
        double price = Util.enterPositiveDoubleWithPromt("Enter Cat Price: ");
        String gender = Util.nextLineWithPromt("Enter Cat Gender (Male/Female): ");

        Cat newCat = new Cat(id, age, price, name, gender);
        petMap.put(id, newCat);
        System.out.println("Cat added successfully!");
    }   

    @Override
    public void remove() {
        System.out.println("--- Remove Cat ---");
        int id = Util.enterPositiveIntWithPromt("Enter Cat ID to remove: ");
        Pet removedCat = petMap.remove(id);
        if(removedCat != null){
            System.out.println("Cat with ID " + id + " removed successfully!");
        }
        else{
            System.out.println("No cat found with ID " + id + ".");
        }
    }
    


    @Override
    public void find() {
        System.out.println("--- Find Cat ---");
        int id = Util.enterPositiveIntWithPromt("Enter Cat ID to find: ");
        Pet foundCat = petMap.get(id);
        if(foundCat != null && foundCat instanceof Cat){
            System.out.println("Cat found:");
            System.out.println(foundCat);
        }
        else{
            System.out.println("No cat found with ID " + id + ".");
        }
    }

    @Override
    public void change() {
        System.out.println("--- Change Cat Information ---");
        int id = Util.enterPositiveIntWithPromt("Enter Cat ID to update: ");
        Pet pet = petMap.get(id);

        if(pet != null && pet instanceof Cat){
            Cat cat = (Cat) pet;
            System.out.println("Current info: " + cat);

            String name = Util.nextLineWithPromt("Enter new name (or press Enter to keep current): ");
            if (!name.isEmpty()) cat.setName(name);

            System.out.print("Enter new age (or -1 to keep current): ");
            int age = Util.enterPositveInt();
            if (age >= 0) cat.setAge(age);

            System.out.print("Enter new price (or -1 to keep current): ");
            double price = Util.entePositiverDouble();
            if (price >= 0) cat.setPrice(price);

            String gender = Util.nextLineWithPromt("Enter new gender (or press Enter to keep current): ");
            if (!gender.isEmpty()) cat.setGender(gender);

            petMap.put(id, cat);
            System.out.println("Cat info updated successfully!");
        }
        else{
            System.out.println("No cat found with ID " + id + ".");
        }
    }

    @Override
    public void viewAll() {
        System.out.println("--- View All Cats ---");
        boolean hasCat = false;
        for(Map.Entry<Integer, Pet> entry : petMap.entrySet()){
            if(entry.getValue() instanceof Cat){
                System.out.println(entry.getValue());
                hasCat = true;
            }
        }
        if(!hasCat){
            System.out.println("No cats found in the system.");
        }
    }

}