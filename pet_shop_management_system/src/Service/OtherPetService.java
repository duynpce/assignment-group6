package Service;

import models.OtherPet;
import Utility.Util;

import java.util.ArrayList;
import java.io.*;

public class OtherPetService implements PetService {

    private static OtherPetService otherPetService;
    private static ArrayList<OtherPet> otherPets;
    private static final String FILE_NAME = "OtherPet.data"; // File to store data

    // Constructor will be called when getInstance() runs the first time
    private OtherPetService() {
        // Load previous data (if any) on startup
        loadData();
    }

    public static OtherPetService getInstance() {
        if (otherPetService == null) {
            otherPetService = new OtherPetService();
        }
        return otherPetService;
    }

    @Override
    public void add() {
        System.out.println("=== Add New Other Pet ===");

        int id = Util.enterPositiveIntWithPromt("Enter pet ID: ");
        String name = Util.nextLineWithPromt("Enter pet name: ");
        int age = Util.enterPositiveIntWithPromt("Enter pet age: ");
        double price = Util.enterPositiveDoubleWithPromt("Enter pet price: ");
        String gender = Util.nextLineWithPromt("Enter pet gender: ");
        String specie = Util.nextLineWithPromt("Enter pet specie: ");

        otherPets.add(new OtherPet(id, age, price, name, gender, specie));
        System.out.println("✅ Other pet added successfully!");

        // --- SAVE DATA ---
        saveData();
    }

    @Override
    public void remove() {
        System.out.println("=== Remove Other Pet ===");
        int id = Util.enterPositiveIntWithPromt("Enter pet ID to remove: ");

        boolean removed = otherPets.removeIf(p -> p.getID() == id);
        if (removed) {
            System.out.println("✅ Removed successfully!");
            // --- SAVE DATA ---
            saveData();
        } else {
            System.out.println("⚠️ Pet not found.");
        }
    }

    @Override
    public void find() {
        System.out.println("=== Find Other Pet ===");
        String name = Util.nextLineWithPromt("Enter pet name to find: ");

        for (OtherPet pet : otherPets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + pet);
                return;
            }
        }
        System.out.println("⚠️ No pet found with that name.");
    }

    @Override
    public void change() {
        System.out.println("=== Change Other Pet Info ===");
        int id = Util.enterPositiveIntWithPromt("Enter pet ID to update: ");

        for (OtherPet pet : otherPets) {
            if (pet.getID() == id) {
                double newPrice = Util.enterPositiveDoubleWithPromt("Enter new price: ");
                pet.setPrice(newPrice);
                System.out.println("✅ Updated successfully!");
                // --- SAVE DATA ---
                saveData();
                return;
            }
        }
        System.out.println("⚠️ Pet not found.");
    }

    @Override
    public void viewAll() {
        System.out.println("=== List of Other Pets ===");
        if (otherPets == null || otherPets.isEmpty()) {
            System.out.println("No other pets available.");
            return;
        }
        for (OtherPet pet : otherPets) {
            System.out.println(pet);
        }
    }

    // =======================================================
    // FUNCTIONS TO SAVE AND LOAD DATA
    // =======================================================

    /**
     * Writes the current otherPets list to the FILE_NAME
     */
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(otherPets);
        } catch (IOException e) {
  
            System.err.println("Error saving OtherPet data: " + e.getMessage());
        }
    }


    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            otherPets = (ArrayList<OtherPet>) ois.readObject();
        } catch (FileNotFoundException e) {

            System.out.println("OtherPet data file not found. Starting with an empty list.");
            otherPets = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
           
            System.err.println("Error loading OtherPet data: " + e.getMessage());
            otherPets = new ArrayList<>();
        }
    }
}
