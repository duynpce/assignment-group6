package library.function;

public  class Screen {
   
    
   
    
    public static void managementScreen(){
        System.out.println("welcome to pet shop management system ");
        System.out.println("features with : ");
        System.out.println("1: pet (add, remove, find, change, preview) ");
        System.out.println("2: customer (add, remove, change, view profile, view transaction history)");
        System.out.println("3: transaction (make, remove, change, find)");
        Utility.makeChoice(1,3);
    }

    public static void inPetScreen(){
        System.out.println("what do you want to operate with ?");
        System.out.println("1 : Dogs");
        System.out.println("2 : Cats"); 
        System.out.println("3 : other animals");
        Utility.makeChoice(1, 3);
        
        PetService.isOtherAnimal = Utility.choice == 3;
        PetService.isCat = Utility.choice == 2;
        PetService.isDog = Utility.choice == 1;

        System.out.println("what kind of operation that you want ?");
        System.out.println("1 : add");
        System.out.println("2 : remove"); 
        System.out.println("3 : find");
        System.out.println("4 : change");
        System.out.println("5 : view all");
        Utility.makeChoice(1, 5);
        switch (Utility.choice) {
            case 1:
                PetService.add();
                break;
            case 2:
                PetService.remove();
                break;
            case 3:
                PetService.find();
                break;
            case 4:
                PetService.change();
                break;
            case 5:
                PetService.viewAll();
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
        System.out.println("6 : view customer transaction");
        Utility.makeChoice(1, 6);
        switch (Utility.choice) {
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
        Utility.makeChoice(1, 4);
        switch (Utility.choice) {
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
