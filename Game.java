import java.util.ArrayList;
import java.util.Scanner;

public class Game {



    public static void main(String[] args) {
        ArrayList<Room> allRooms = Room.getRooms();

        //read item file ~   ~   ~   ~
        System.out.println("creating items..");
        Item.readItems();


        // read rooms ~   ~   ~   ~
        System.out.println("creating rooms..");
        Room.readRooms();





        Scanner scan = new Scanner(System.in);
        boolean gameRunning = true;
        //player creation

        

        //create player; (change x in getRoom(allRooms,x) to starting room id)
        System.out.println("name your player:");
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


                                    //check if item requirement
                                    if ((currentChallenge.getItemReq()==null)||(currentChallenge.getItemReq()[choiceInt]==null)||currentPlayer.hasItem(currentChallenge.getItemReq()[choiceInt])){
                                        
                                        System.out.println(currentChallenge.getResponses()[choiceInt]);

                                        //health checker
                                        if (currentChallenge.getHealth()[choiceInt]!=0){
                                            System.out.println(currentChallenge.getHealth()[choiceInt]+" hp");
                                            currentPlayer.addHealth(currentChallenge.getHealth()[choiceInt]);
                                        }

                                        //rewards checker
                                        
                                        // for (String x:currentChallenge.getRewards()){
                                        //     System.out.println(x==null?false:x.equals("null"));
                                        // }

                                        if (currentChallenge.getRewards()!=null&&currentChallenge.getRewards()[choiceInt]!=null&&!currentChallenge.getRewards()[choiceInt].equals("null")){
                                            System.out.println("you have acquired "+Item.getName(currentChallenge.getRewards()[choiceInt]));
                                            currentPlayer.addItem(Item.createItem(currentChallenge.getRewards()[choiceInt]));;
                                        }

                                        //check if repeatable
                                        // System.out.println(currentChallenge.getRepeatable()[choiceInt]);
                                        if (currentChallenge.getRepeatable()[choiceInt]==false){
                                            isSolving = false;
                                            currentChallenge.complete();
                                        }

                                        //open doors if can
                                        if (currentChallenge.getOpenDoors()[choiceInt]==true){
                                            currentPlayer.getLocation().openDoors();
                                        }

                                        //win detection
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
        System.out.println("Thank you for playing, "+currentPlayer.getName()+"!");
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