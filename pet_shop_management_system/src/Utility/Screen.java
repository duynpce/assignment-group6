package Utility;

import Service.CustomerService;
import Service.DogService;
import Service.CatService;
import Service.OtherPetService;
import Service.TransactionService;

public  class Screen {
    private static DogService dogService  = DogService.getInstance();
    private static CatService catService  = CatService.getInstance();
    private static OtherPetService otherPetService  = OtherPetService.getInstance();
    
    public static void managementScreen(){
        System.out.println("welcome to pet shop management system ");
        System.out.println("features with : ");
        System.out.println("1: pet (add, remove, find, change, preview) ");
        System.out.println("2: customer (add, remove, change, view profile, view transaction history)");
        System.out.println("3: transaction (make, remove, change, find)");
        Util.makeChoice(1,3);
    }

    public static void inPetScreen(){

        System.out.println("what kind of operation that you want ?");
        System.out.println("1 : add");
        System.out.println("2 : remove"); 
        System.out.println("3 : find");
        System.out.println("4 : change");
        System.out.println("5 : view all");

        System.out.println("what do you want to operate with ?");
        System.out.println("1 : Dogs");
        System.out.println("2 : Cats"); 
        System.out.println("3 : other animals");
        Util.makeChoice(1, 3);
        switch (Util.choice) {
            case 1:
                inDogScreen();
                break;
            case 2: 
                inCatScreen();
                break;
            case 3:
                inOtherPetScreen();
                break;
        }
       
    }


    private static void inDogScreen(){

        Util.makeChoice(1, 5);
        switch (Util.choice) {
            case 1:
                dogService.add();
                break;
            case 2:
                dogService.remove();
                break;
            case 3:
                dogService.find();
                break;
            case 4:
                dogService.change();
                break;
            case 5:
                dogService.viewAll();
                break;
        }
    }

    public static void inCatScreen(){

       
        Util.makeChoice(1, 5);
        switch (Util.choice) {
            case 1:
                catService.add();
                break;
            case 2:
                catService.remove();
                break;
            case 3:
                catService.find();
                break;
            case 4:
                catService.change();
                break;
            case 5:
                catService.viewAll();
                break;
        }
    }

    public static void inOtherPetScreen(){

        Util.makeChoice(1, 5);
        switch (Util.choice) {
            case 1:
                otherPetService.add();
                break;
            case 2:
                otherPetService.remove();
                break;
            case 3:
                otherPetService.find();
                break;
            case 4:
                otherPetService.change();
                break;
            case 5:
                otherPetService.viewAll();
                break;
        }
    }

    
    public static void inCustomerScreen(){
        System.out.println("what kind of operation that you want ?");
        System.out.println("1 : add");
        System.out.println("2 : remove"); 
        System.out.println("3 : find");
        System.out.println("4 : change");
        System.out.println("5 : view all profile");
        System.out.println("6 : view customer transation history");
        Util.makeChoice(1, 6);
        switch (Util.choice) {
            case 1:
                CustomerService.add();
                break;
            case 2:
                CustomerService.remove();
                break;
            case 3:
                CustomerService.find();
                break;
            case 4:
                CustomerService.change();
                break;
            case 5:
                CustomerService.viewAllProfile();
                break;
            case 6: 
                CustomerService.viewCustomerTransaction();
                break;
        }
    }

    public static void inTransactionScreen(){
        System.out.println("what kind of operation that you want ?");
        System.out.println("1 : make");
        System.out.println("2 : remove"); 
        System.out.println("3 : find");
        System.out.println("4 : change");
        Util.makeChoice(1, 4);
        switch (Util.choice) {
            case 1:
                TransactionService.make();
                break;
            case 2:
                TransactionService.remove();
                break;
            case 3:
                TransactionService.find();
                break;
            case 4:
                TransactionService.change();
                break;
        }
    }

}
