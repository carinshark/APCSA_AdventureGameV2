import java.util.ArrayList;
import java.util.Scanner;

public class Game {



    public static void main(String[] args) {
        ArrayList<Room> allRooms = new ArrayList<Room>();

        //ITEMS ~   ~   ~   ~
        Item map = new Item("Map", "Hope you know how to read it! - your favorite wizard statue", -1, 0, "*********\n*O-O-O***\n*****|***\n*****O-O*\n*****|*|*\n*O-O-O*O*\n*******|*\n*O*****O*\n*******|*");
        Item potion = new Item("Health Potion","\"One sip is all it takes!\" Contains 2 servings.", 2,20,null);
        Item chalice = new Item("Schrodinger's Chalice", "A 50% chance of surviving you had… the other 50% is in here", 1, -1000, "Bleh :p");
        Item tomato = new Item("Tomato Rock", "It looks like a tomato... but easy to tell when you hold it", 0, 0, null);
        Item carrot = new Item("Carrot Rock", "It looks like a carrot... Hard to tell apart", 0, 0, null);
        Item hammer = new Item("Blacksmith's hammer", "The free trial version! Use in a forge", 0, 0, null);
        Item shield = new Item("Shield", "When the time's right, deflect any attack", -1, 0, "There's nothing to block...");
        Item fork = new Item("Fork", "Yum yum", -1, 0, "You put the fork in your mouth. You enjoy the delicious oxygen you just ate.");


        //ROOMS ~   ~   ~   ~
        
        // ROOM 0000
        String[] c0000 = {"Go into the door","Approach the bird"};
        String[] res0000 = {"You walk into a dark room. All of a sudden the ground slides open and you fall onto a slide which brings you into a room underground, and the way you came in closes. It looks like this room also closes as soon as you step out.","The hummingbird pecks at you! You get knocked back to the door"};
        int[] h0000 = {0,-10};
        Item[] rew0000 = {null,null};
        boolean[] rep0000 = {false,true};
        boolean[] doorOpens0000 = {true,false};
        Item[] req0000 = null;
        boolean[] win0000 = null;

        allRooms.add(new Room("Tavern",0,"n",
        "You wake up in... a cardboard box in the back of the tavern? You open a door that leads outside, but before you take a step, you hear a loud chirp and stop.",
        new Challenge( "A very angry looking hummingbird wearing a cloak stands on the other side of the door. You also notice a door behind you.", c0000, res0000, h0000, rew0000, doorOpens0000, rep0000, req0000, win0000),
        false));



        //ROOM 100
        String[] c100 = {"To Explore","To Kill Everything","I had no choice"};
        String[] res100 = { "Wow that's amazing! Have this map :3 I shall turn back into stone now byeee","oh… :( bye - I shall return to the stone","Aw :( here have this regen potion for when you need it, now I shall become rock once more"};
        int[] h100 = {0,0,0};
        Item[] rew100 = {map,null,potion};
        boolean[] rep100 = {false,false,false};
        boolean[] doorOpens100 = {true,true,true};
        Item[] req100 = null;
        boolean[] win100 = null;
        allRooms.add(new Room("Guardian",100,"ne","There is a stone statue of a wizard in front of you.",
        new Challenge( "The wizard comes to life! It says: I AM THE GUARDIAN OF THIS HERE DUNGEON!! WHAT IS YOUR PURPOSE FOR BEING HERE", c100, res100, h100, rew100, doorOpens100, rep100, req100, win100),false));

        //ROOM 101
        String[] c101 = { "Do nothing","Drink from the chalice"};
        String[] res101 = { "Oh no! You tried to walk away and tripped on a table leg! Your fall clears your mind, but really hurts.","You feel wonky. You are dead and alive at the same time! But then, you observe yourself and realize you are alive. You also feel fully healed"};
        int[] h101 = { -10,100};
        Item[] rew101 = {null,chalice};
        boolean[] rep101 = {false,false};
        boolean[] doorOpens101 = {true,true};
        Item[] req101 = null;
        boolean[] win101 = null;
        allRooms.add(new Room( "Schrodinger's Chalice",101,"ew", "You see a table in the middle of the room. There are 3 vials in front of you and a chalice. One vial says \"heal anything in the world!\", the second one says \"kill anything in the world\" and the third one looks to be some kind of poison",
        new Challenge( "All of a sudden, a mysterious force takes over your body! You pour the first two vials into the chalice, and drink the third one. You start to feel weird and your vision gets blurry.", c101, res101, h101, rew101, doorOpens101, rep101, req101, win101),false));


        //ROOM 102
        String[] c102 = { "Pick up the tomato rock","Pick up the carrot rock"};
        String[] res102 = { "It's a red rock… all of a sudden a rat runs by and steals the other one","It's an orange rock… all of a sudden a rat runs by and steals the other one."};
        int[] h102 = {0,0};
        Item[] rew102 = {tomato,carrot};
        boolean[] rep102 = {false,false};
        boolean[] doorOpens102 = {true,true};
        Item[] req102 = null;
        boolean[] win102 = null;
        allRooms.add(new Room("Pantry",102,"nw", "You enter a room with minimal lighting. There appears to be food on high shelves, but they’re all painted rocks",
        new Challenge( "2 of the rocks fall to the ground. one looks like a carrot, and the other a tomato.", c102, res102, h102, rew102, doorOpens102, rep102, req102, win102),true));


        //ROOM 202
        String[] c202 = {"Drink Healing Potion"};
        String[] res202 = {"You feel refreshed and regenerated"};
        int[] h202 = {100};
        Item[] rew202 = {null};
        boolean[] rep202 = {true};
        boolean[] doorOpens202 = {true};
        Item[] req202 = null;
        boolean[] win202 = null;
        allRooms.add(new Room(NAME,202,DOORS,DESCRIPTION,
        new Challenge( PROMPT, c202, res202, h202, rew202, doorOpens202, rep202, req202, win202),LEAVE));

        


        Scanner scan = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("what is your name?");
        Player currentPlayer = new Player(scan.nextLine(),getRoom(allRooms, 0));
        
        String playerResponse = "";
        boolean isSolving = false;
        int choiceInt;
        Challenge currentChallenge;

        boolean inInventory = false;
        Item currentItem;

        
        //startRoom description
        System.out.println(currentPlayer.getLocation().getDescription());
        
        // game loop
        while (gameRunning) {
            System.out.print("your move(type \"h\" for options): ");
            playerResponse = scan.nextLine();
            
            if (playerResponse.equals("h")){
                System.out.println("h - help\nend - end game loop\nmove - switch rooms\nsolve- do the room's challenge\ninventory - show and use items in inventory");
            }
            else if (playerResponse.equals("end")){
                gameRunning = false;
            }
            else if (playerResponse.equals("move")){
                if (currentPlayer.getLocation().canLeave()){
                    System.out.print("pick a direction:");
                    for (int i =0;i<currentPlayer.getLocation().getDoors().length();i++){
                        System.out.print(currentPlayer.getLocation().getDoors().substring(i,i+1));
                        if (i!=currentPlayer.getLocation().getDoors().length()-1) {
                            System.err.println(",");
                        }

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
                        System.out.println(currentPlayer.getLocation().getDescription());
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
                        System.out.println("Your choices:(type \"return\" to go back to player moves)");
                        for (int i = 0; i < currentChallenge.getChoices().length; i++) {
                            if (((currentChallenge.getItemReq()==null)||currentChallenge.getItemReq()[i]==null) || (currentPlayer.getInventory().contains(currentChallenge.getItemReq()[i]))){
                                System.out.println(i+": "+currentChallenge.getChoices()[i]);
                            }
                        }
                        playerResponse = scan.nextLine();
                        if (playerResponse.equals("return")) {
                            isSolving = false;
                        }
                        else if (playerResponse.length()==1){
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
            
            else if (playerResponse.equals("inventory")){
                for (Item item:currentPlayer.getInventory()){
                    System.out.println(item.getName());
                }
                while (inInventory){
                    System.out.println("make your move(\"h\" for help)");
                    playerResponse = scan.nextLine();

                    if (playerResponse.equals("return")){
                        inInventory = false;
                    }
                    else if (playerResponse.equals("h")) {
                        System.out.println("return - go back to game\nlist - lists items\n view itemName - shows more options about an item");
                    }
                    else if (playerResponse.equals("list")){
                        for (Item item:currentPlayer.getInventory()){
                            System.out.println(item.getName());
                        }
                    }
                    else if (playerResponse.startsWith("view ")){
                        currentItem = currentPlayer.getItem(playerResponse.substring(5));
                        if (currentItem!=null){
                            System.out.println(currentItem.getName());
                            System.out.println("\""+currentItem.getText()+"\"");
                            System.out.print("Options:");
                            if (currentItem.getUses()!=0){
                                System.out.println("would you like to use this item?(\"y\"/\"n\")");
                                if (scan.nextLine().equals("y")){
                                    currentItem.use();
                                }
                            }
                        } else{
                            System.out.println("this item does not exist!");
                        }
                    }



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