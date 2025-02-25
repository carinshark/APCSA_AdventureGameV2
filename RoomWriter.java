
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RoomWriter{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        

        //read inventory file, add to Item class static variable to store for future refrence
        try {
            File gameData = new File("GameItems.txt");
            Scanner fileReader = new Scanner(gameData);
            int braceDelimiter = 0;
            int quotationDelimiter = 0;
            while (fileReader.hasNextLine()) { 
                System.out.println(fileReader.nextLine());
                
            }

        } catch (FileNotFoundException e) {
            System.out.println("GAME DATA MISSING!!!!!!!!!");
            e.printStackTrace();
        }







    }
}