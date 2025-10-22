package Service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import Utility.Util;
import models.Transaction;
import Enum.Constant;

import java.time.LocalDateTime;

public class TransactionService {
    private static int IDcount = 0;
    private static final String transactionFile = Constant.TRANSACTION_FILE.getFileName();
    private static HashMap <Integer, Transaction> transactionMap = new HashMap<>();

 
    public static void save(){
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(transactionFile))){
            for (Transaction transaction : transactionMap.values()) {
             writeFile.writeObject(transaction);   
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    public static void load(){
        Transaction transaction = new Transaction();
       try(ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(transactionFile))){
        try{
            while(true){
            IDcount ++;
            transaction = (Transaction) readFile.readObject();
            transactionMap.put(transaction.getID(),transaction);
            }
        }catch(EOFException error){
            }
        }catch(IOException | ClassNotFoundException error){
            // error.printStackTrace();
       }
       IDcount = transactionMap.size();
    }

    public static void make(){/// change to confirm before make , and automaticlly add price and require pet ID
        Transaction transaction = new Transaction();
        transaction.setID(++IDcount);
        int customerID = Util.enterPositiveIntWithPromt("please enter customer's ID: ");
        if(!CustomerService.customerMap.containsKey(customerID)){
            System.out.println("Not exsited cumstomer's ID, make transaction failed");
            --IDcount;
            return;
        }
        int petID =  Util.enterPositiveIntWithPromt("please enter pet's ID: ");
        if(!PetService.petMap.containsKey(petID)){
            System.out.println("Not exsited pet's ID, make transaction failed");
            --IDcount;
            return;
        }
        transaction.setValue(PetService.petMap.get(petID).getPrice());
        transaction.setTime(LocalDateTime.now().toString());
        System.out.println("\ncustomer's ID :" + customerID);
        transaction.display();
        String confirm = Util.nextLineWithPromt("enter yes to confirm to make this transaction: ");
        if(!confirm.toLowerCase().equals("yes") ){
            System.out.println("transaction canceled");
            --IDcount;
            return;
        }

        transactionMap.put(transaction.getID(),transaction);
        CustomerService.customerMap.get(customerID).addTransaction(transaction);
        System.out.println("add successfully");
    }

    public static void remove(){
        int ID = Util.enterPositiveIntWithPromt("enter ID to remove: ");
        if(!transactionMap.containsKey(ID)){
            System.out.println("ID not exsited");
            return;
        }
        transactionMap.remove(ID);

        File currentFile = new File("temptransaction.data");
        File oldFile = new File(transactionFile);
        try{
            currentFile.createNewFile();
        }catch(Exception error){}
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(currentFile))){
            for(Integer key : transactionMap.keySet()){
                if(transactionMap.get(key).getID() == ID) continue;
                writeFile.writeObject(transactionMap.get(key));
            }
        }catch(IOException error){
            // error.printStackTrace();
        }

        if(oldFile.delete()){
            currentFile.renameTo(oldFile);
            System.out.println("Remove successfully");
        }
        else {
            System.out.println("can not delete file transaction.data, remove failed");
            currentFile.delete();
        }
    }

    
    public static void find(){
        int ID = Util.enterPositiveIntWithPromt("enter ID to find: ");
        if(!transactionMap.containsKey(ID)){
            System.out.println("ID not exsited");
            return;
        }
        System.out.println();
        transactionMap.get(ID).display();

    }

    public static void change(){
        Transaction transaction = new Transaction();
        int ID = Util.enterPositiveIntWithPromt("enter ID to change: ");
        if(!transactionMap.containsKey(ID)) {
            System.out.println("ID not exsited");
            return;
        }
        File currentFile = new File("temptransaction.data");
        File oldFile = new File( transactionFile);

        System.out.println("what do want to change ");
        System.out.println("1 ID, 2 value, 3 time");
        System.out.println("enter correspond number");
        Util.makeChoice(1, 3);
        switch (Util.choice) {
            case 1:
                int newID = Util.enterPositiveIntWithPromt("please enter new ID");
                transactionMap.get(ID).setID(newID);
                transaction = transactionMap.get(ID);
                transactionMap.remove(ID);
                transactionMap.put(newID, transaction);
                break;
            case 2:
                double newValue = Util.enterPositiveDoubleWithPromt("please enter new value");
                transactionMap.get(ID).setValue(newValue);
                break;
            case 3:
                String newTime = Util.nextLineWithPromt("please enter new Time");
                transactionMap.get(ID).setTime(newTime);
                break;
        }
        
        try{
            currentFile.createNewFile();
        }catch(Exception error){}
        try(ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(currentFile))){
            for(Integer key : transactionMap.keySet()){
                writeFile.writeObject(transactionMap.get(key));
            }
        }catch(IOException error){
            error.printStackTrace();
        }

        if(oldFile.delete()){
            currentFile.renameTo(oldFile);
            System.out.println("change successfully");
        }
        else {
            System.out.println("can not delete file transaction.data, change failed");
        }
    }
}
