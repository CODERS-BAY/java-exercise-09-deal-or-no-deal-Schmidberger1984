package application;

import java.util.Scanner;

public class Console {

    public static int input(String out){
        Scanner scanner = new Scanner (System.in);
        boolean again=false;
        int value=1;
        do {
            System.out.print((out));
            try {
                again=false;
                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Please enter a number.");
                again=true;
            }
            if (value <1 || value > 26) {
                System.out.println("Input is not in range of 1-26.");
                again=true;
            }
        }while (again==true);
        return  value-1;
    }

    public static String abort(){
        Scanner scanner = new Scanner(System.in);
        boolean again=true;
        String value="";
        do {
            System.out.print("Please press Y/y for YES and N/n for NO:");
            value=scanner.nextLine();
            if (value.toLowerCase().equals("n") || value.toLowerCase().equals("y")) again=false;
        }while (again==true);
        return value.toLowerCase();
    }

    public static void lastQuestion( Suitcase suitcase, int pickSuitcaseNumber, double pickSuitcaseVaule) {
        System.out.println("\nThe suitcase with your price was number " + pickSuitcaseNumber + ".");
        System.out.println("Suitcase number " + suitcase.lastSuitcaseNumber() + " is the last one remaining.");
        System.out.println("\nNow we give you a chance to switch to this suitcase.");
        System.out.println("Do you want to switch suitcases?");
        if (Console.abort().equals("n")) {
            System.out.println("Opening suitcase number " + pickSuitcaseNumber + ".");
            System.out.println("Congratulations, you won " + pickSuitcaseVaule + "$.");
        } else {
            System.out.println("Opening suitcase number " + suitcase.lastSuitcaseNumber() + ".");
            System.out.println("Congratulations, you won " + suitcase.lastSuitcaseValue() + "$.");
        }
    }
}
