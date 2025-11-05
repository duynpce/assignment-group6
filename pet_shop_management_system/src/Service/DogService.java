package Service;

import Utility.Util;
import models.Cat;
import models.Dog;
import models.OtherPet;
import models.Pet;

import java.util.Map;

public class DogService implements PetService{
    
    
    private static DogService dogService;

    private DogService() {
    }

    public static DogService getInstance() {
        if (dogService == null) {
            dogService = new DogService();
        }
        return dogService;
    }

    @Override
    public void add() {
        System.out.println("----- Add New Dog -----");
        int id = Util.enterPositiveIntWithPromt("Enter Dog ID: ");
        if (petMap.containsKey(id)){
            System.out.println("A animal with this ID already exists!");
            return;
        }
        String name = Util.nextLineWithPromt("Enter Dog Name: ");
        int age = Util.enterPositiveIntWithPromt("Enter Dog Age: ");
        double price = Util.enterPositiveDoubleWithPromt("Enter Dog Price: ");

        String gender = Util.nextLineWithPromt("Enter Dog Gender (Type in either Male or Female): ");
        while(!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")){
            gender = Util.nextLineWithPromt("Invalid gender, please enter again: ");
        }

        Dog newDog = new Dog(id, age, price, name, gender);
        petMap.put(id, newDog);
        System.out.println("New dog added successfully!");
    }

    @Override
    public void remove() {
        System.out.println("----- Remove Dog -----");
        int id = Util.enterPositiveIntWithPromt("Enter Dog ID to begin removing: ");
        if(petMap.containsKey(id)){
            petMap.remove(id);
            System.out.println("* Remove Dog: " + id + " successfully!");
        }
        else{
            System.out.println("No exist Dog with the ID: " + id);
        }
    }

    @Override
    public void find() {
        System.out.println("----- Find Dog -----");
        int id = Util.enterPositiveIntWithPromt("Enter Dog ID to begin finding: ");
        Pet foundAnimal = petMap.get(id);
        if(foundAnimal instanceof Dog){
            System.out.println("* Found this little Dog: ");
            foundAnimal.display();
        }
        else if(foundAnimal instanceof Cat){
            System.out.println("No exist Dog but found Cat with the ID " + id);
            foundAnimal.display();
        }
        else if(foundAnimal instanceof OtherPet){
            System.out.println("No exist Dog but found Other Pet with the ID " + id);
            foundAnimal.display();
        }
        else{
            System.out.println("No exist Dog with the ID " + id);
        }
    }

    @Override
    public void change() {
        System.out.println("----- Edit Dog Information -----");
        int id = Util.enterPositiveIntWithPromt("Enter Dog ID to begin editing: ");
        Pet pet = petMap.get(id);

        if(pet instanceof Dog){
            Dog dog = (Dog) pet;
            System.out.println("Current information: ");
            dog.display();
            boolean isEditing = true;
            while(isEditing){
                System.out.println("\nWhat you want to change?");
                System.out.println("1: Name | 2: Age | 3: Price | 4: Gender | 5: Exit");
                Util.makeChoice(1,5);
                switch (Util.choice){
                    case 1:
                        String newName = Util.nextLineWithPromt("Enter new name: ");
                        if (!newName.isEmpty()){
                            dog.setName(newName);
                            System.out.println("✔ Update Name Successfully!");
                        }
                        break;
                    case 2:
                        int newAge = Util.enterPositiveIntWithPromt("Enter new age: ");
                        dog.setAge(newAge);
                        System.out.println("✔ Update Age Successfully!");
                        break;
                    case 3:
                        double newPrice = Util.enterPositiveDoubleWithPromt("Enter new Price: ");
                        dog.setPrice(newPrice);
                        System.out.println("✔ Update Price Successfully!");
                        break;
                    case 4:
                        String newGender = Util.nextLineWithPromt("Enter new gender: ");
                        while(!newGender.equalsIgnoreCase("Male") && !newGender.equalsIgnoreCase("Female")){
                            newGender = Util.nextLineWithPromt("Invalid gender, please enter again: ");
                        }
                        dog.setGender(newGender);
                        System.out.println("✔ Update Gender Successfully!");
                        break;
                    case 5:
                        isEditing = false;
                        System.out.println("Exit Editing...\n");
                        break;
                }

                if(isEditing){
                    String isContinue;
                    do{
                        isContinue = Util.nextLineWithPromt("Do you want to continue editing (Y/N): ");
                        if(!isContinue.equalsIgnoreCase("Y")&&!isContinue.equalsIgnoreCase("N")){
                            System.out.println("Invalid input. Please enter Y or N");
                        }
                    } while (!isContinue.equalsIgnoreCase("Y")&&!isContinue.equalsIgnoreCase("N"));
                    if(isContinue.equalsIgnoreCase("N")){
                        isEditing = false;
                        System.out.println("Exit Editing...\n");
                    }
                }
            }
        }
        else if(pet instanceof Cat){
            System.out.println("No exist Dog because found Cat with the ID " + id + " instead");
        }
        else if(pet instanceof OtherPet){
            System.out.println("No exist Dog but found Other Pet with the ID " + id + " instead");
        }
        else{
            System.out.println("No exist Dog but with the ID " + id + " instead");
        }
    }

    @Override
    public void viewAll() {
        System.out.println("----- Display all Dogs -----");
        boolean hasDog = false;
        System.out.println("-----------------------------------------------------");
        System.out.printf("|%-5s|%-20s|%-5s|%-10s|%-7s|\n", "ID", "Name", "Age", "Price", "Gender");
        System.out.println("|-----|--------------------|-----|----------|-------|");
        for(Map.Entry<Integer, Pet> entry : petMap.entrySet()){
            Pet pet = entry.getValue();
            if(pet instanceof Dog){
                Dog dog = (Dog) pet;
                System.out.printf("|%-5d|%-20s|%-5d|%-10.2f|%-7s|\n", dog.getID(), dog.getName(), dog.getAge(), dog.getPrice(), dog.getGender());
                hasDog = true;
            }
        }
        if(!hasDog){
            System.out.printf("|%-51s|\n","No dogs found in the system.");
        }
        System.out.println("-----------------------------------------------------");
    }
}