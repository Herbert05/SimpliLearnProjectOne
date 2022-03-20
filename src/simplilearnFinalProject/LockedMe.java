package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
        try{
            Scanner obj = new Scanner(System.in);
            String fileName;
            System.out.println("Please enter new file name: ");
            fileName = obj.nextLine();

            int lineCounts;
            System.out.println("Enter number of lines that your file will contain: ");
            //Use parser instead of nextInt to avoid the script from skipping first line
            lineCounts = Integer.parseInt(obj.nextLine());

            FileWriter fileWriter = new FileWriter(projectFilesPath + FileSystems.getDefault().getSeparator() + fileName + ".txt");

            //Read line by line from user
            String customerEntry;
            for(int i = 0; i < lineCounts; i++){
                System.out.println("Enter file line: ");
                customerEntry = obj.nextLine();
                fileWriter.write( customerEntry + "\n");
            }
            fileWriter.close();
            System.out.println("File created successfully");
        }catch (NumberFormatException ex){
            System.out.println("Number Error: " + ex.getMessage());
        }catch (Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }
    }

    /**
     * This function will allow user to delete a file inside our working directory
     */
    public static void deleteFiles(){
        try{
            Scanner obj = new Scanner(System.in);
            String fileName;
            System.out.println("Enter file name to be deleted: ");
            fileName = obj.nextLine();
            //Check if file exists
            if(!checkFileExists(fileName)){
                System.out.println("File does not exists");
                return;
            }
            //File exists now attempt to delete
            File f = new File(projectFilesPath + FileSystems.getDefault().getSeparator() + fileName);
            if(f.delete())
                System.out.println("File deleted successfully");
            else
                System.out.println("Attempted to delete file but failed for some reasons.");
        }catch (Exception e){
            System.out.println("Unable to delete file. Please contact administrator");
        }
    }

    /**
     * This function will allow user to search for a file from files inside our working directory
     */
    public static void searchFiles(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter file name to search in the working directory: ");
        String fileName;
        fileName = obj.nextLine();
        if(checkFileExists(fileName)){
            System.out.println("File is available");
        }else{
            System.out.println("File is not available");
        }
    }

    private static boolean checkFileExists(String fileName){
        ArrayList<String> fileNames = new ArrayList<>();
        File folder = new File(projectFilesPath);
        for(File f: Objects.requireNonNull(folder.listFiles())){
            fileNames.add(f.getName());
        }
        return fileNames.contains(fileName);
    }
}
