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
        boolean[] doorOpens0000 = {true,false};
        Item[] req0000 = null;
        boolean[] win0000 = null;


        allRooms.add(new Room("Tavern",0,"n",
        "You wake up in… a cardboard box in the back of the tavern? You open a door that leads outside, but before you take a step, you hear a loud chirp and stop.",
        new Challenge( "A very angry looking hummingbird wearing a cloak stands on the other side of the door. You also notice a door behind you.", c0000, res0000, h0000, rew0000, doorOpens0000, rep0000, req0000, win0000),
        false));


        Scanner scan = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("what is your name?");
        Player currentPlayer = new Player(scan.nextLine(),getRoom(allRooms, 0));
        
        String playerResponse = "";
        boolean isSolving = false;
        int choiceInt;
        Challenge currentChallenge;
        while (gameRunning) {
            System.out.print("your move(type \"h\" for options): ");
            playerResponse = scan.nextLine();
            
            if (playerResponse.equals("h")){
                System.out.println("h - help\nend - end game loop\nmove - switch rooms\nsolve- do the room's challenge");
            }
            else if (playerResponse.equals("end")){
                gameRunning = false;
            }
            else if (playerResponse.equals("move")){
                if (currentPlayer.getLocation().canLeave()){
                    System.out.print("pick a direction:");
                    for (int i =0;i<currentPlayer.getLocation().getDoors().length();i++){
                        System.out.print(currentPlayer.getLocation().getDoors().substring(i,i+1)+", ");

                    }
                    playerResponse = scan.nextLine();
                    if (currentPlayer.getLocation().getDoors().indexOf(playerResponse)>=0 && playerResponse.length()==1){
                        if (playerResponse.equals("n")){
                            currentPlayer.setLocation(getRoom(allRooms, currentPlayer.getLocation().getId()+100));
                        } else if (playerResponse.equals("s")){
                            currentPlayer.setLocation(getRoom(allRooms, currentPlayer.getLocation().getId()-100));
                        } else if (playerResponse.equals("e")){
                            currentPlayer.setLocation(getRoom(allRooms, currentPlayer.getLocation().getId()+10));
                        } else if (playerResponse.equals("w")){
                            currentPlayer.setLocation(getRoom(allRooms, currentPlayer.getLocation().getId()-10));
                        }
                        
                    }
                    else{
                        System.out.println("that is not a valid move!");
                    }
                    
                } else{
                    System.out.println("The doors are not open yet! Try solving the puzzle!");
                }
                

            }

            else if (playerResponse.equals("solve")) {
                if (!currentPlayer.getLocation().getChallenge().isComplete()){
                    System.out.println(currentPlayer.getLocation().getChallenge().getPrompt());

                    
                    isSolving = true;
                    while (isSolving){
                        currentChallenge = currentPlayer.getLocation().getChallenge();
                        System.out.println("Your choices:(type return to go back to player moves)");
                        for (int i = 0; i < currentChallenge.getChoices().length; i++) {
                            System.out.println(i+": "+currentChallenge.getChoices()[i]);
                        }
                        playerResponse = scan.nextLine();
                        if (playerResponse.length()==1){
                            choiceInt = Integer.parseInt(playerResponse);
                            if (choiceInt>=0&&choiceInt<currentChallenge.getChoices().length){

                                if (currentChallenge.getItemReq()==null||currentPlayer.getInventory().contains(currentChallenge.getItemReq()[choiceInt])){

                                    System.out.println(currentChallenge.getResponses()[choiceInt]);
                                    if (currentChallenge.getHealth()[choiceInt]!=0){
                                        System.out.println(currentChallenge.getHealth()[choiceInt]+" hp");
                                        currentPlayer.addHealth(currentChallenge.getHealth()[choiceInt]);
                                    }
                                    if (currentChallenge.getRewards()[choiceInt]!=null){
                                        System.out.println("you have aquired "+currentChallenge.getRewards()[choiceInt].getName());
                                        currentPlayer.getInventory().add(currentChallenge.getRewards()[choiceInt]);
                                        currentChallenge.getRewards()[choiceInt].setParent(currentPlayer);
                                    }
                                    if (currentChallenge.getRepeatable()[choiceInt]==false){
                                        isSolving = false;
                                    }
                                    if (currentChallenge.getOpenDoors()[choiceInt]==true){
                                        currentPlayer.getLocation().openDoors();
                                    }
                                    if (currentChallenge.getWin()!=null){
                                        if (currentChallenge.getWin()[choiceInt]){
                                            System.out.println("Nice job! you won the game!");
                                            gameRunning = false;
                                            isSolving = false;
                                        }
                                    }


                                } else{
                                    System.out.println("you don't have the item needed for this!");
                                }


                                
                            } else{
                                System.out.println("this choice is not one of the options!");
                            }




                        } else{
                            System.out.println("this is not a valid response - please pick a number!");
                        }
                    }

                    





                }else{
                    System.out.println("this room is already complete! try moving to a different rome with \"move\"");
                }
            }
            else{
                System.out.println("I dont know what that is.");
            }
            
            


        }
        System.out.println("Thank you for playing!");


    }


    public static Room getRoom(ArrayList<Room> rooms,int position){
        for (int i=0;i<rooms.size();i++){

            if (rooms.get(i).getId()==position){
                return rooms.get(i);
            }
        }
        System.out.println("ROOM NOT FOUND:"+position);
        return null;
    }





    
}