import java.util.Scanner;

public class Game {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("what is your name?");
        Player currentPlayer = new Player(scan.nextLine(), null);
        
        String playerResponse = "";

        while (gameRunning) {
            System.out.print("your move: ");
            playerResponse = scan.nextLine();
            




            playerResponse = scan.nextLine();


        }


    }
    
}