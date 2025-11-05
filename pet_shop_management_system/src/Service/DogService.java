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
        while(!gender.equals("Male") && !gender.equals("Female")){
            gender = Util.nextLineWithPromt("invalid gender, enter again: ");
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

            String newName = Util.nextLineWithPromt("Enter new name (press Enter to pass): ");
            if (!newName.isEmpty()) dog.setName(newName);

            System.out.print("Enter new age (press -1 to pass): ");
            int newAge = Util.enterPositveInt();
            if (newAge >= 0) dog.setAge(newAge);

            System.out.print("Enter new price (press -1 to pass): ");
            double newPrice = Util.entePositiverDouble();
            if (newPrice >= 0) dog.setPrice(newPrice);

            String newGender = Util.nextLineWithPromt("Enter new gender (press Enter to pass): ");
            if (!newGender.isEmpty()) dog.setGender(newGender);

            petMap.put(id, dog);
            System.out.println("* Edit Dog Information successfully!");
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
            if(entry.getValue() instanceof Dog){
                System.out.printf("|%-5d|%-20s|%-5d|%-10lf|%-7s|\n", entry.getValue().getID(), entry.getValue().getName(), entry.getValue().getAge(), entry.getValue().getPrice(), entry.getValue().getGender());
                hasDog = true;
            }
        }
        if(!hasDog){
            System.out.printf("|%-51s|\n","No dogs found in the system.");
        }
        System.out.println("-----------------------------------------------------");
    }
}