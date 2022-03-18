package simplilearnFinalProject;

import java.util.Scanner;

public class Main {

    //Entry point of our application
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int choice;
        do{
            //Display our menu items
            LockedMe.displayMenu();
            //Prompt for user input
            System.out.println("Enter your choice: ");
            choice = obj.nextInt();
            switch (choice){
                case 1: LockedMe.getAllFiles();
                    break;
                case 2: LockedMe.createFiles();
                    break;
                case 3: LockedMe.deleteFiles();
                    break;
                case 4: LockedMe.searchFiles();
                    break;
                case 5: System.exit(0);
                    break;
                default: System.out.println("Invalid Input");
                    break;
            }
        }while(choice>0);

        obj.next();
        obj.close();
    }
}
