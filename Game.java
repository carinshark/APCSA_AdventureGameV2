import java.util.ArrayList;
import java.util.Scanner;

public class Game {



    public static void main(String[] args) {
        ArrayList<Room> allRooms = new ArrayList<Room>();
        
        String[] c0000 = {"Go into the door","Approach the bird"};
        String[] res0000 = {"You walk into a dark room. All of a sudden the ground slides open and you fall onto a slide which brings you into a room underground, and the way you came in closes. It looks like this room also closes as soon as you step out.","The hummingbird pecks at you! You get knocked back to the door"};
        int[] h0000 = {0,-10};
        Item[] rew0000 = {null,null};
        boolean[] rep0000 = {false,true};
        boolean[] doorOpens = {true,false};

        allRooms.add(new Room("Tavern",0,"n",
        "You wake up in… a cardboard box in the back of the tavern? You open a door that leads outside, but before you take a step, you hear a loud chirp and stop.",
        new Challenge( "A very angry looking hummingbird wearing a cloak stands on the other side of the door. You also notice a door behind you.", c0000, res0000, h0000, h0000, doorOpens, rep0000, rew0000, rep0000),
        false));


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
                    if (currentPlayer.getLocation().canLeave()){
                        System.out.print("pick a direction:");
                        for (int i =0;i<currentPlayer.getLocation().getDoors().length();i++){
                            System.out.print(currentPlayer.getLocation().getDoors().substring(i,i+1)+", ");

                        }
                        playerResponse = scan.nextLine();
                        if (currentPlayer.getLocation().getDoors().indexOf(playerResponse)>0 && playerResponse.length()==1){
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