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
        String gender = "";
        while(true){
            gender = Util.nextLineWithPromt("Enter Cat Gender (Male/Female): ");
            if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                break;
            }
            else{
                System.out.println("Invalid input! Please enter only 'Male' or 'Female'");
            }
        }

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
            System.out.println("No cat found with ID " + id);
        }
    }



    @Override
    public void find() {
        System.out.println("--- Find Cat ---");
        int id = Util.enterPositiveIntWithPromt("Enter Cat ID to find: ");
        Pet foundCat = petMap.get(id);
        if(foundCat != null && foundCat instanceof Cat){
            System.out.println("Cat found:");
            foundCat.display();
        }
        else{
            System.out.println("No cat found with ID " + id);
        }
    }

    @Override
    public void change() {
        System.out.println("--- Change Cat Information ---");
        int id = Util.enterPositiveIntWithPromt("Enter Cat ID to update: ");
        Pet pet = petMap.get(id);

        if(pet != null && pet instanceof Cat) {
            Cat cat = (Cat) pet;
            System.out.println("Current info: ");
            cat.display();

            boolean continueEdit = true;
            while(continueEdit){
                System.out.println("What do you want to change?");
                System.out.println("1 Age | 2 Price | 3 Name | 4 Gender | 5 Exit");
                System.out.println("Enter Your Choice(1-5): ");
                Util.makeChoice(1, 5);

                switch (Util.choice) {
                    case 1:
                        int newAge = Util.enterPositiveIntWithPromt("Enter Cat Age: ");
                        cat.setAge(newAge);
                        System.out.println("Cat Age updated successfully!");
                        break;
                    case 2:
                        double newPrice = Util.enterPositiveDoubleWithPromt("Enter Cat Price: ");
                        cat.setPrice(newPrice);
                        System.out.println("Cat Price updated successfully!");
                        break;
                    case 3:
                        String newName = Util.nextLineWithPromt("Enter Cat Name: ");
                        cat.setName(newName);
                        System.out.println("Cat Name updated successfully!");
                        break;
                    case 4:
                        String newGender = Util.nextLineWithPromt("Enter Cat Gender: ");
                        cat.setGender(newGender);
                        System.out.println("Cat Gender updated successfully!");
                        break;
                    case 5:
                        continueEdit = false;
                        System.out.println("--- Exiting ---");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
                if(continueEdit){
                    String edit = Util.nextLineWithPromt("Do you want to continue editing (Yes/No)");
                    while(!edit.equalsIgnoreCase("Yes") && !edit.equalsIgnoreCase("No")){
                        edit = Util.nextLineWithPromt("Invalid input! Plese enter Yes or No");
                    }
                    if(edit.equalsIgnoreCase("No")){
                        continueEdit = false;
                        System.out.println("--- Exiting ---");
                    }
                }
            }
        }
        else{
            System.out.println("Cat ID not existed!");
        }
    }

    @Override
    public void viewAll() {
        System.out.println("--- View All Cats ---");
        boolean hasCat = false;
        for(Pet pet: petMap.values()){
            if(pet instanceof Cat){
                pet.display();
                System.out.println();
                hasCat = true;
            }
        }
        if(!hasCat){
            System.out.println("No cats found in the system.");
        }
    }

}