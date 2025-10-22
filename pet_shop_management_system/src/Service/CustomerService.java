package Service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import Enum.Constant;

import Utility.Util;
import models.Customer;

public class CustomerService {
    private static final String customerFile = Constant.CUSTOMER_FILE.getFileName();
    protected static HashMap <Integer, Customer> customerMap = new HashMap<>();

    public static void save(){
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(customerFile))){
            for (Customer customer : customerMap.values()) {
             writeFile.writeObject(customer);   
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    public static void load(){
        Customer customer = new Customer();
       try(ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(customerFile))){
        try{
            while(true){
            customer = (Customer) readFile.readObject();
            customerMap.put(customer.getID(),customer);
            }
        }catch(EOFException error){
            }
        }catch(IOException | ClassNotFoundException error){
            // error.printStackTrace();
       }
    }

    public static void add(){
        Customer customer = new Customer();
        customer.setID(Util.enterPositiveIntWithPromt("please enter ID: "));
        if(customerMap.containsKey(customer.getID())){
            System.out.println("ID existed, add failed");
            return;
        }

        customer.setAge(Util.enterPositiveIntWithPromt("please enter age: "));
        customer.setName(Util.nextLineWithPromt("please enter name: "));
        customer.setGender(Util.nextLineWithPromt("please enter gender: "));

        customerMap.put(customer.getID(),customer);
        System.out.println("add successfully");
    }

    public static void remove(){
        int ID = Util.enterPositiveIntWithPromt("enter ID to remove: ");
        if(!customerMap.containsKey(ID)){
            System.out.println("ID not exsited");
            return;
        }
        customerMap.remove(ID);

        File currentFile = new File("tempcustomer.data");
        File oldFile = new File(customerFile);
        try{
            currentFile.createNewFile();
        }catch(Exception error){}
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(currentFile))){
            for(Integer key : customerMap.keySet()){
                if(customerMap.get(key).getID() == ID) continue;
                writeFile.writeObject(customerMap.get(key));
            }
        }catch(IOException error){
            // error.printStackTrace();
        }

        if(oldFile.delete()){
            currentFile.renameTo(oldFile);
            System.out.println("Remove successfully");
        }
        else {
            System.out.println("can not delete file customer.data, remove failed");
            currentFile.delete();
        }
    }

    
    public static void find(){
        int ID = Util.enterPositiveIntWithPromt("enter ID to find: ");
        if(!customerMap.containsKey(ID)){
            System.out.println("ID not exsited");
            return;
        }
        customerMap.get(ID).display();

    }

    public static void change(){
        Customer customer = new Customer();
        int ID = Util.enterPositiveIntWithPromt("enter ID to change: ");
        if(!customerMap.containsKey(ID)) {
            System.out.println("ID not exsited");
            return;
        }
        File currentFile = new File("tempcustomer.data");
        File oldFile = new File( customerFile);

        System.out.println("what do want to change ");
        System.out.println("1 ID, 2 age, 3 name, 4 gender");
        System.out.println("enter correspond number");
        Util.makeChoice(1, 4);
        switch (Util.choice) {
            case 1:
                int newID = Util.enterPositiveIntWithPromt("please enter new ID");
                customerMap.get(ID).setID(newID);
                customer = customerMap.get(ID);
                customerMap.remove(ID);
                customerMap.put(newID, customer);
                break;
            case 2:
                int newAge = Util.enterPositiveIntWithPromt("please enter new Age");
                customerMap.get(ID).setAge(newAge);
                break;
            case 3:
                String newName = Util.nextLineWithPromt("please enter new Name");
                customerMap.get(ID).setName(newName);
                break;
            case 4:
                String newGender = Util.nextLineWithPromt("please enter new Gender");
                customerMap.get(ID).setGender(newGender);
                break;
        }
        
        try{
            currentFile.createNewFile();
        }catch(Exception error){}
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(currentFile))){
            for(Integer key : customerMap.keySet()){
                writeFile.writeObject(customerMap.get(key));
            }
        }catch(IOException error){
            error.printStackTrace();
        }

        if(oldFile.delete()){
            currentFile.renameTo(oldFile);
            System.out.println("change successfully");
        }
        else {
            System.out.println("can not delete file customer.data, change failed");
        }
    }

    public static void viewAllProfile(){
        
        if(customerMap.isEmpty()){
            System.out.println("No profile existed");
            return;
        }
        for (Customer customer : customerMap.values()) {
            customer.display();
            System.out.println();
        }
    }

    public static void viewCustomerTransaction(){
        int ID = Util.enterPositiveIntWithPromt("please enter customer's ID: ");
        if(!customerMap.containsKey(ID)){
            System.out.println("Not existed ID");
            return;
        }
        System.out.println();
        customerMap.get(ID).displayStransactionHistory();
    }
}
