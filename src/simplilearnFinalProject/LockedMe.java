package simplilearnFinalProject;

import java.io.File;

public class LockedMe {

    //Our working directory
    static final String projectFilesPath="/Users/herbert.temba/Documents/SimpliLearn/ProjectOneCWD/";

    /**
     * This function will display application name developer name and available options.
     */
    public static void displayMenu(){
        System.out.println("********************************************");
        System.out.println("\tWelcome to LockedMe.com secure app");
        System.out.println("\tDeveloped by : Herbert Gunibert Temba");
        System.out.println("********************************************");
        System.out.println("\t1. Display all files");
        System.out.println("\t2. Add a new file");
        System.out.println("\t3. Delete a file");
        System.out.println("\t4. Search file");
        System.out.println("\t5. Exit");
    }

    /**
     * This function will display all files under our working directory
     */
    public static void getAllFiles(){
        File folder = new File(projectFilesPath);
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for(File l:listOfFiles){
            System.out.println(l.getName());
        }
    }

    /**
     * This function will allow user to create file
     */
    public static void createFiles() {
        System.out.println("Function to allow user to create file in our working directory and add content add content to the file");
    }

    /**
     * This function will allow user to delete a file inside our working directory
     */
    public static void deleteFiles(){
        System.out.println("Function to delete file");
    }

    /**
     * This function will allow user to search for a file from files inside our working directory
     */
    public static void searchFiles(){
        System.out.println("Function to search file by accepting user input");
    }
}
