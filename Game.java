import java.util.Scanner;

public class Game {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("what is your name?");
        Player currentPlayer = new Player(scan.nextLine(),null);
        
        String playerResponse = "";

        while (gameRunning) {
            System.out.print("your move(type \"h\" for options): ");
            playerResponse = scan.nextLine();
            
            switch (playerResponse) {
                case "h":
                    System.out.println("h - help\n");
                    break;
                case "move":
                    if (currentPlayer.location.canLeave){
                        System.out.print("pick a direction:");
                        for (int i =0;i<currentPlayer.location.doors.length();i++){
                            System.out.print(currentPlayer.location.doors.substring(i,i+1)+", ");

                        }
                        playerResponse = scan.nextLine();
                        if (currentPlayer.location.doors.indexOf(playerResponse)>0 && playerResponse.length()==1){
                            if (playerResponse.equals("n")){
                                
                            } else if (playerResponse.equals("s")){

                            } else if (playerResponse.equals("e")){

                            } else if (playerResponse.equals("w")){

                            }
                        }
                        else{
                            System.out.println("that is not a valid move!");
                        }
                        
                    } else{
                        System.out.println("The doors are not open yet!");
                    }
                    


                default:
                    System.out.println("I dont know what that is.");
            }
            


        }


    }
    
}