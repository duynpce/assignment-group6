package library.function;


import java.util.Scanner;
import java.util.Random;

public class Utility{
    public static final Scanner SC = new Scanner(System.in);
    public static final Random RD = new Random();
    public static int choice = -1;

    public static void makeChoice (int begin, int end  ){
        choice = -1;
        while (choice > end || choice < begin){
            try {
            choice = SC.nextInt();
            SC.nextLine();
            if(choice > end || choice < begin){
                System.out.println("please enter from " + begin + " to " + end);
            }
            }
        catch(Exception error){
             System.out.println("Invalid input the enter a number");
             SC.nextLine();
            }
        }
    }

    public static int enterPositveInt(){
        int Int = -1;
        while(Int < 0){
            try {
            Int = SC.nextInt();
            SC.nextLine();
            }
        catch(Exception error){
             System.out.println("Invalid input the enter a number");
             SC.nextLine();
            }
        }
        return Int;
    }
    public static int enterPositiveIntWithPromt(String notification){
        System.out.print(notification);
        return enterPositveInt();
    }

    public static double entePositiverDouble(){
        double Double = -1;
        while(Double < 0){
            try {
            Double = SC.nextDouble();
            SC.nextLine();
            }
        catch(Exception error){
             System.out.println("Invalid input the enter a number");
             SC.nextLine();
            }
        }
        return Double;
    }
    public static double enterPositiveDoubleWithPromt(String notification){
        System.out.print(notification);
        return entePositiverDouble();
    }

    public static String nextLineWithPromt(String notification){
        System.out.print(notification);
        return SC.nextLine();
    }
}
