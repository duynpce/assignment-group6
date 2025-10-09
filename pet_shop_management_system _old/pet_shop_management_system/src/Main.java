
import library.function.*;
public class Main {
    public static void main(String[] args) {
        boolean running = true;
        PetService.load();
        CustomerService.load();
        TransactionService.load();
        while(running){
            Screen.managementScreen();
            switch (Utility.choice) {
                case 1:
                    Screen.inPetScreen();
                    break;
                case 2:
                    Screen.inCustomerScreen();
                    break;
                case 3:
                    Screen.inTransactionScreen();
            }
            int stop = Utility.enterPositiveIntWithPromt("enter 1 to stop the program ");
            running =  stop != 1;
        } 
        PetService.save();
        CustomerService.save();
        TransactionService.save();   
    } 
}
