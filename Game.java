import java.util.ArrayList;
import java.util.Scanner;

public class Game {



    public static void main(String[] args) {
        ArrayList<Room> allRooms = Room.getRooms();

        //read item file ~   ~   ~   ~
        Item.readItems();


        // read rooms ~   ~   ~   ~
        Room.readRooms();
        // // ROOM 0000
        // String[] c0000 = {"Go into the door","Approach the bird"};
        // String[] res0000 = {"You walk into a dark room. All of a sudden the ground slides open and you fall onto a slide which brings you into a room underground, and the way you came in closes. It looks like this room also closes as soon as you step out.","The hummingbird pecks at you! You get knocked back to the door"};
        // int[] h0000 = {0,-10};
        // Item[] rew0000 = {null,null};
        // boolean[] rep0000 = {false,true};
        // boolean[] doorOpens0000 = {true,false};
        // Item[] req0000 = null;
        // boolean[] win0000 = null;
        
        // allRooms.add(new Room("Tavern",0,"n",
        // "You wake up in... a cardboard box in the back of the tavern? You open a door that leads outside, but before you take a step, you hear a loud chirp and stop.",
        // new Challenge( "A very angry looking hummingbird wearing a cloak stands on the other side of the door. You also notice a door behind you.", c0000, res0000, h0000, rew0000, doorOpens0000, rep0000, req0000, win0000),
        // false));



        // //ROOM 100
        // String[] c100 = {"To Explore","To Kill Everything","I had no choice"};
        // String[] res100 = { "Wow that's amazing! Have this map :3 I shall turn back into stone now byeee","oh… :( bye - I shall return to the stone","Aw :( here have this regen potion for when you need it, now I shall become rock once more"};
        // int[] h100 = {0,0,0};
        // Item[] rew100 = {map,null,potion};
        // boolean[] rep100 = {false,false,false};
        // boolean[] doorOpens100 = {true,true,true};
        // Item[] req100 = null;
        // boolean[] win100 = null;
        // allRooms.add(new Room("Guardian",100,"ne","There is a stone statue of a wizard in front of you.",
        // new Challenge( "The wizard comes to life! It says: I AM THE GUARDIAN OF THIS HERE DUNGEON!! WHAT IS YOUR PURPOSE FOR BEING HERE", c100, res100, h100, rew100, doorOpens100, rep100, req100, win100),false));

        // //ROOM 101
        // String[] c101 = { "Do nothing","Drink from the chalice"};
        // String[] res101 = { "Oh no! You tried to walk away and tripped on a table leg! Your fall clears your mind, but really hurts.","You feel wonky. You are dead and alive at the same time! But then, you observe yourself and realize you are alive. You also feel fully healed"};
        // int[] h101 = { -10,100};
        // Item[] rew101 = {null,chalice};
        // boolean[] rep101 = {false,false};
        // boolean[] doorOpens101 = {true,true};
        // Item[] req101 = null;
        // boolean[] win101 = null;
        // allRooms.add(new Room( "Schrodinger's Chalice",101,"ew", "You see a table in the middle of the room. There are 3 vials in front of you and a chalice. One vial says \"heal anything in the world!\", the second one says \"kill anything in the world\" and the third one looks to be some kind of poison",
        // new Challenge( "All of a sudden, a mysterious force takes over your body! You pour the first two vials into the chalice, and drink the third one. You start to feel weird and your vision gets blurry.", c101, res101, h101, rew101, doorOpens101, rep101, req101, win101),false));


        // //ROOM 102
        // String[] c102 = { "Pick up the tomato rock","Pick up the carrot rock"};
        // String[] res102 = { "It's a red rock... all of a sudden a rat runs by and steals the other one","It's an orange rock... all of a sudden a rat runs by and steals the other one."};
        // int[] h102 = {0,0};
        // Item[] rew102 = {tomato,carrot};
        // boolean[] rep102 = {false,false};
        // boolean[] doorOpens102 = {true,true};
        // Item[] req102 = null;
        // boolean[] win102 = null;
        // allRooms.add(new Room("Pantry",102,"nw", "You enter a room with minimal lighting. There appears to be food on high shelves, but they're all painted rocks",
        // new Challenge( "2 of the rocks fall to the ground. one looks like a carrot, and the other a tomato.", c102, res102, h102, rew102, doorOpens102, rep102, req102, win102),true));


        // //ROOM 202
        // String[] c202 = {"Drink Healing Potion"};
        // String[] res202 = {"You feel refreshed and regenerated"};
        // int[] h202 = {100};
        // Item[] rew202 = {null};
        // boolean[] rep202 = {true};
        // boolean[] doorOpens202 = {true};
        // Item[] req202 = null;
        // boolean[] win202 = null;
        // allRooms.add(new Room("Room of Healing",202,"nse", "A room for resting… a room to prepare you for what's ahead… There are cups of healing potions everywhere",
        // new Challenge( "Take what you need. \n Potions kindly donated by the Wizard Statue Society", c202, res202, h202, rew202, doorOpens202, rep202, req202, win202),true));


        // //ROOM 200
        // String[] c200 = { "Yes!","No!!!","I prefer the art of combat"};
        // String[] res200 = { "Have a free trial blacksmith hammer! You only get one use out of it :)\nthe blacksmith disappears in a blinding light, leaving nothing but a hammer behind","ok  ToT \nthe blacksmith runs away crying to a secret door that closes behind him","I see I see… too bad for you I only make weapons not use them :p\nthe blacksmith vanished before your eyes."};
        // int[] h200 = {0,0,0};
        // Item[] rew200 = {hammer,null,null};
        // boolean[] rep200 = {false,false,false};
        // boolean[] doorOpens200 = {true,true,true};
        // Item[] req200 = null;
        // boolean[] win200 = null;
        // allRooms.add(new Room("Summoning Altar",200,"ns", "You see an encryption on the wall, but cannot make sense of it.",
        // new Challenge( "Someone wearing a leather apron holding a hammer stands in front of you. They ask you: \"are you interested in the art of blacksmithing?\"", c200, res200, h200, rew200, doorOpens200, rep200, req200, win200),false));



        // //ROOM 300
        // String[] c300 = { "Pour Healing Potion","Go Around the lava","Jump over it"};
        // String[] res300 = { "The healing potion manages to cool down the lava just enough to walk over it.","You follow the lava back to your original position, for the moat surrounds you entirely.","You manage to jump over the lava, but a little bit splashes onto you. It burns."};
        // int[] h300 = {0,0,-40};
        // Item[] rew300 = {null,null,null};
        // boolean[] rep300 = {false,true,false};
        // boolean[] doorOpens300 = {true,false,true};
        // Item[] req300 = {potion,null,null};
        // boolean[] win300 = null;
        // allRooms.add(new Room("Lava River",300,"se","You arrive at a room with with an empty circular moat in the center.",
        // new Challenge(  "You hear gears rotating, and lava starts flowing, filling up the moat. The lava constantly splashes upwards.", c300, res300, h300, rew300, doorOpens300, rep300, req300, win300),false));


        // //ROOM 301
        // String[] c301 = { "Nothing","Shield","Fork"};
        // String[] res301 = { "The forge looks at you sadly…","You crafted a shield that can deflect anything!","A fork… Interesting choice!"};
        // int[] h301 = {0,0,0};
        // Item[] rew301 = {null,shield,fork};
        // boolean[] rep301 = {true,true,true};
        // boolean[] doorOpens301 = {true,true,true};
        // Item[] req301 = {null,hammer,hammer};
        // boolean[] win301 = null;
        // allRooms.add(new Room("Forge",301,"ew","Craft to your heart's desire… If you have a hammer",
        // new Challenge( "What would you like to craft?", c301, res301, h301, rew301, doorOpens301, rep301, req301, win301),true));



        // //ROOM 302
        // String[] c302 = { "rock","paper","scissors"};
        // String[] res302 = { "You win!","You tie!","You lost!"};
        // int[] h302 = {0,0,0};
        // Item[] rew302 = {null,null,null};
        // boolean[] rep302 = {false,false,false};
        // boolean[] doorOpens302 = {true,true,true};
        // Item[] req302 = null;
        // boolean[] win302 = null;
        // allRooms.add(new Room("Challenger",302,"sw","A very competitive person stands in the middle of the room",
        // new Challenge( "They ask you to a friendly game of rock paper scissors!", c302, res302, h302, rew302, doorOpens302, rep302, req302, win302),false));


        // //ROOM 203
        // allRooms.add(new Room("Warning Room",203,"ws","Be warned… if south you turn, there shall be no return",
        // null,true));



        // //ROOM 103
        // String[] c103 = { "I don't have anything","Give Health Potion","Give Schrödinger's Chalice","Give Tomato Rock","Give Carrot Rock","Use Fork"};
        // String[] res103 = { "You watch them eat a feast, and then kill you.","The mysterious person feels fully healed! They then proceed to kill you…","You give them the chalice. They drink it. They proceed to exist and not exist at the same time, but then gets observed and dies.","You give them the rock. They see through it instantly and throws it at your feet. They try kill you, but at the last minute trip on the rock and fall flat on you","They try eating it, but being a rock, it was hard. They are so focused on it that you can slip right past.","You use the fork and eat a small portion of food, making it impossible to finish the feast, so you survive."};
        // int[] h103 = { -100,-100,0,-90,0,0};
        // Item[] rew103 = { null,null,null,null,null,null};
        // boolean[] rep103 = { false,false,false,false,false,false};
        // boolean[] doorOpens103 = { false,false,true,true,true,true};
        // Item[] req103 = {null,potion,chalice,tomato,carrot,fork};
        // boolean[] win103 = null;
        // allRooms.add(new Room("Feasting Hall",103,"s","No turning back now... \nYou see someone sitting in front of you across a table.",
        // new Challenge("The mysterious person tells you that they are gonna kill you after eating the feast. They proceed to ask you if you brought anything with you for them to feast on", c103, res103, h103, rew103, doorOpens103, rep103, req103, win103),false));
        

        // //ROOM 3
        // String[] c3 = { "Do nothing","Use map","Throw tomato rock","Throw carrot rock","Use Shield"};
        // String[] res3 = { "The wizard casts a fireball upon you. It really hurts.","You hold out the map. A fireball comes at you and goes right through it.","The wizard catches the rock. All of a sudden, it says \"Oh I love tomatoes I'm gonna put this on my shelf!\"","You throw the tomato rock, intercepting a fireball midair. The wizard looks angry.","Your shield causes the spell to bounce back and defeat the wizard!"};
        // int[] h3 = { -50,-50,0,0,0};
        // Item[] rew3 = { null,null,null,null,null};
        // boolean[] rep3 = { true,true,false,true,false};
        // boolean[] doorOpens3 = { false,false,false,false,false};
        // Item[] req3 = {null,map,tomato,carrot,shield};
        // boolean[] win3 = { false,false,true,false,true};
        // allRooms.add(new Room("End…?",3,"", "The statue of the wizard returns… It comes to life!!! ",
        // new Challenge("The wizard prepares to attack. Looks like it's charging up a spell, giving you time"
        // , c3, res3, h3, rew3, doorOpens3, rep3, req3, win3),false));






        Scanner scan = new Scanner(System.in);
        boolean gameRunning = true;
        //player creation
        System.out.println("what is your name?");
        Player currentPlayer = new Player(scan.nextLine(),getRoom(allRooms, 0));
        
        
        String playerResponse = "";
        boolean isSolving = false;
        int choiceInt;
        Challenge currentChallenge;
        boolean gameWon = false;
        
        boolean inInventory = false;
        Item currentItem;

        
        //startRoom description
        System.out.println("Room: "+currentPlayer.getLocation().getName());
        System.out.println(currentPlayer.getLocation().getDescription());
        
        // game loop
        while (gameRunning) {
            System.out.println("\n");
            System.out.print("your move(type \"h\" for options): ");
            playerResponse = scan.nextLine();
            System.out.println();
            //choice options
            if (playerResponse.equals("h")){
                System.out.println("h - help\nend - end game loop\nmove - switch rooms\nsolve- do the room's challenge\ninventory - show and use items in inventory");
            }
            //end game
            else if (playerResponse.equals("end")){
                gameRunning = false;
            }
            //move to different room(if allowed)
            else if (playerResponse.equals("move")){
                if (currentPlayer.getLocation().canLeave()){
                    System.out.print("pick a direction:");
                    for (int i =0;i<currentPlayer.getLocation().getDoors().length();i++){
                        System.out.print(currentPlayer.getLocation().getDoors().substring(i,i+1));
                        if (i!=currentPlayer.getLocation().getDoors().length()-1) {
                            System.out.print(",");
                        }
                        else{
                            System.out.println();
                        }

                    }
                    playerResponse = scan.nextLine();
                    if (currentPlayer.getLocation().getDoors().indexOf(playerResponse)>=0 && playerResponse.length()==1){
                        if (playerResponse.equals("n")){
                            currentPlayer.setLocation(getRoom(allRooms, currentPlayer.getLocation().getId()+100));
                        } else if (playerResponse.equals("s")){
                            currentPlayer.setLocation(getRoom(allRooms, currentPlayer.getLocation().getId()-100));
                        } else if (playerResponse.equals("e")){
                            currentPlayer.setLocation(getRoom(allRooms, currentPlayer.getLocation().getId()+1));
                        } else if (playerResponse.equals("w")){
                            currentPlayer.setLocation(getRoom(allRooms, currentPlayer.getLocation().getId()-1));
                        }
                        System.out.println("Room: "+currentPlayer.getLocation().getName());
                        System.out.println(currentPlayer.getLocation().getDescription());
                    }
                    else{
                        System.out.println("that is not a valid move!");
                    }
                    
                } else{
                    System.out.println("The doors are not open yet! Try solving the puzzle!");
                }
                

            }
            //solve puzzle(list choices, pick index of choice, and determine outputs)
            else if (playerResponse.equals("solve")) {
                if (currentPlayer.getLocation().getChallenge()!=null){
                    if (!currentPlayer.getLocation().getChallenge().isComplete()){
                        System.out.println(currentPlayer.getLocation().getChallenge().getPrompt());

                        
                        isSolving = true;
                        while (isSolving){
                            currentChallenge = currentPlayer.getLocation().getChallenge();
                            System.out.println("Your choices:(type \"return\" to go back to player moves)");
                            for (int i = 0; i < currentChallenge.getChoices().length; i++) {
                                //checks if there is an item requirement --> checks if player has item
                                if (((currentChallenge.getItemReq()==null)||currentChallenge.getItemReq()[i]==null) || (currentPlayer.hasItem(currentChallenge.getItemReq()[i]))){
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

                                    if ((currentChallenge.getItemReq()==null)||(currentChallenge.getItemReq()[choiceInt]==null)||currentPlayer.hasItem(currentChallenge.getItemReq()[choiceInt])){

                                        System.out.println(currentChallenge.getResponses()[choiceInt]);
                                        if (currentChallenge.getHealth()[choiceInt]!=0){
                                            System.out.println(currentChallenge.getHealth()[choiceInt]+" hp");
                                            currentPlayer.addHealth(currentChallenge.getHealth()[choiceInt]);
                                        }
                                        if (currentChallenge.getRewards()[choiceInt]!=null){
                                            System.out.println("you have acquired "+Item.getName(currentChallenge.getRewards()[choiceInt]));
                                            currentPlayer.getInventory().add(Item.createItem(currentChallenge.getRewards()[choiceInt]));
                                            currentPlayer.getInventory().getLast().setParent(currentPlayer);
                                        }
                                        if (currentChallenge.getRepeatable()[choiceInt]==false){
                                            isSolving = false;
                                            currentChallenge.complete();
                                        }
                                        if (currentChallenge.getOpenDoors()[choiceInt]==true){
                                            currentPlayer.getLocation().openDoors();
                                        }
                                        if (currentChallenge.getWin()!=null){
                                            if (currentChallenge.getWin()[choiceInt]){
                                                System.out.println("Nice job! you won the game!");
                                                gameRunning = false;
                                                isSolving = false;
                                                gameWon = true;
                                            }
                                        }
                                        //remove item if was a requirement
                                        if (currentChallenge.getItemReq()!=null&&currentChallenge.getItemReq()[choiceInt]!=null){
                                            currentPlayer.removeItem(currentChallenge.getItemReq()[choiceInt]);
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

                            if (!currentPlayer.isAlive()){
                                isSolving = false;
                            }

                        }

                    }else{
                        System.out.println("this room is already complete! try moving to a different rome with \"move\"");
                    }
                } else{
                    System.out.println("there is nothing to do in this room, try a different room!");
                }
            }
            

            // inventory - shows item name, description, and option to use if able to
            else if (playerResponse.equals("inventory")){
                if (currentPlayer.getInventory().size()>0){
                    for (Item item:currentPlayer.getInventory()){
                        System.out.println(item.getName());
                    }
                } else{
                    System.out.println("your inventory is empty.");
                }
                inInventory = true;
                while (inInventory){
                    System.out.println("Inventory: make your move(\"h\" for help)");
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

                    if (!currentPlayer.isAlive()){
                        inInventory = false;
                    }

                }
            }
            
            //false
            else{
                System.out.println("I dont know what that is.");
            }
            
            
            if (!currentPlayer.isAlive()){
                gameRunning = false;
            }

        }
        if (gameWon){
            System.out.println("YOU WON!!!! WOOOOOOO");
        }
        System.out.println("Thank you for playing!");
        scan.close();


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