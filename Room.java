
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Room {

    private static ArrayList<Room> rooms= new ArrayList<Room>();
    
    private String name;
    private final int id;
    private String doors;
    private String description;
    private Challenge challenge;
    private boolean canLeave;


    public Room(String name,int id,String doors,String description,Challenge challenge,boolean canLeave){
        this.name = name;
        this.id = id;
        this.doors = doors;
        this.description = description;
        this.challenge = challenge;
        this.canLeave = canLeave;
    }



    public String getDoors(){
        return doors;
    }

    public boolean canLeave(){
        return canLeave;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }
    public Challenge getChallenge(){
        return challenge;
    }
    public void openDoors(){
        canLeave = true;
    }

    public String getDescription(){
        return description;
    }
    
    public static void writeRooms(){
        try {
            File gameData = new File("GameRooms.txt");
            Scanner fileReader = new Scanner(gameData);
            
            boolean inRoom = false;
            String[] roomData = new String[13];
            
            while (fileReader.hasNextLine()) { 
                String currentLine = fileReader.nextLine();
                
                if (currentLine.equals("{")&&!inRoom){
                    inRoom = true;
                    roomData = new String[7];

                }
                else if(currentLine.equals("}")&&inRoom){
                    inRoom = false;
                    boolean allAccounted = true;
                    for (int i=0;i<6;i++){
                        if (roomData[i]==null){
                            allAccounted=false;
                        }
                    }
                    
                    
                    if (allAccounted){
                        if (roomData[6]==null){
                            rooms.add(new Room());
                        } else{
                            rooms.add(new Room());
                        }
                    }
                    else{
                        System.err.println("THINGS ARE MISSING!");
                    }



                }
                else if (inRoom){
                    if (currentLine.contains("name:")){
                        roomData[0] = currentLine.substring(currentLine.indexOf("name:")+5);
                    }
                    else if (currentLine.contains("id:")){
                        roomData[1] = currentLine.substring(currentLine.indexOf("id:")+3);
                    }
                    
                }
                

                
                


                
            }
            

            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("GAME DATA MISSING!!!!!!!!!(GameRooms.txt)");
            e.printStackTrace();
        }
    }


}
