
import Service.CustomerService;
import Service.PetService;
import Service.TransactionService;
import Utility.*;
public class Main {
    public static void main(String[] args) {
        boolean running = true;

        TransactionService.load();
        CustomerService.load();
        PetService.load();
        while(running){
            Screen.managementScreen();
            switch (Util.choice) {
                case 1:
                    Screen.inPetScreen();
                    break;
                case 2:
                    Screen.inCustomerScreen();
                    break;
                case 3:
                    Screen.inTransactionScreen();
            }
            int stop = Util.enterPositiveIntWithPromt("enter 1 to stop the program ");
            running =  stop != 1;
        } 
        PetService.save();
        TransactionService.save();
        CustomerService.save();

    } 
}
