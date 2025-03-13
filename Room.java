
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


    public Room(String name,int id,String doors,String description,boolean canLeave,Challenge challenge){
        this.name = name;
        this.id = id;
        this.doors = doors;
        this.description = description;
        this.challenge = challenge;
        this.canLeave = canLeave;
    }

    public String toString(){
        String output = "";    
        output+="name:"+name+"\n";
        output+="id:"+id+"\n";
        output+="doors:"+doors+"\n";
        output+="description:"+description+"\n";
        output+=challenge.toString()+"\n";
        output+="canLeave:"+canLeave;


        return output;
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
            
            
            String[] identifiers = {"name","id","doors","description","canLeave","prompt","choices","responses","health","reward","repeatable","doorOpens","itemReq","win"};
            

            String[] roomData = new String[identifiers.length];

            while (fileReader.hasNextLine()) { 
                String currentLine = fileReader.nextLine();
                // System.out.println(currentLine);
                
                if (currentLine.equals("{")&&!inRoom){
                    inRoom = true;
                    roomData = new String[identifiers.length];

                }
                else if(currentLine.equals("}")&&inRoom){
                    inRoom = false;
                    boolean allAccounted = true;
                    for (int i=0;i<10;i++){
                        if (roomData[i]==null){
                            allAccounted=false;
                        }
                        else if (roomData[i].equals("null")){
                            roomData[i] = null;
                        }
                        else if(roomData[i].contains("\\n")){
                            while (roomData[i].contains("\\n")) {
                                roomData[i] = roomData[i].substring(0,roomData[i].indexOf("\\n"))+"\n"+roomData[i].substring(roomData[i].indexOf("\\n")+2);
                            }
                        }
                    }
                    
                    
                    if (allAccounted){
                        rooms.add(new Room(
                            roomData[0],
                            Integer.parseInt(roomData[1]),
                            roomData[2],
                            roomData[3],
                            Boolean.getBoolean(roomData[4]),
                            new Challenge(
                                roomData[5],
                                readArray(roomData[6]),
                                readArray(roomData[7]),
                                parseIntArray(readArray(roomData[8])),
                                readArray(roomData[9]),
                                parseBooleanArray(readArray(roomData[10])),
                                parseBooleanArray(readArray(roomData[11])),
                                readArray(roomData[12]),
                                parseBooleanArray(readArray(roomData[13]))
                                )
                            )
                        );
                    }
                    else{
                        System.err.println("THINGS ARE MISSING!");
                    }



                }
                else if (inRoom){
                    for (int i=0;i<identifiers.length;i++){
                        if(currentLine.startsWith(identifiers[i]+":")){
                            roomData[i] = currentLine.substring(identifiers[i].length()+1);
                        }
                    }
                    
                }
                

                
                


                
            }
            
            //TESTING
            System.out.println("a");
            for (Room room:rooms) System.out.println(room.toString());
            System.out.println("b");


            fileReader.close();

        } 
        catch (FileNotFoundException e) {
            System.out.println("GAME DATA MISSING!!!!!!!!!(GameRooms.txt)");
            e.printStackTrace();
        }
    }


    public static int[] parseIntArray(String[] strs){
        if (strs==null){

            return null;
        }
        int[] nums = new int[strs.length];
        for (int i=0;i<strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        return nums;
    }

    public static boolean[] parseBooleanArray(String[] strs){
        if (strs==null){

            return null;
        }

        boolean[] nums = new boolean[strs.length];
        for (int i=0;i<strs.length;i++){
            nums[i] = Boolean.getBoolean(strs[i]);
        }

        return nums;
    }

    public static String[] readArray(String str){
        if (str==null){

            return null;
        }
        
        String arrayString = str.substring(0);
        int seperatorCounter = 0;
        String seperator = ";";

        //count seperators
            while (arrayString.indexOf(seperator)>=0) {
                seperatorCounter++;
                arrayString = arrayString.substring(arrayString.indexOf(seperator)+1);

            }
        
        
        String[] formedArray = new String[seperatorCounter];
        System.out.println(str);
        // arrayString = str.substring(str.indexOf(seperator)+1,str.indexOf(seperator));

        for (int i=0;i<formedArray.length;i++){
            if (arrayString.contains(seperator)){
                formedArray[i] = arrayString.substring(0,arrayString.indexOf(seperator));
                arrayString = arrayString.substring(arrayString.indexOf(seperator)+1);
            }
            else{
                formedArray[i] = arrayString;
            }


        }
        
        return formedArray;


    }
    public static void main(String[] args) {
        Room.writeRooms();
    }


}
