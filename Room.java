
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
        output+=challenge!=null?challenge.toString():null+"\n";
        output+="canLeave:"+canLeave;


        return output;
    }


    public static ArrayList<Room> getRooms(){
        return rooms;
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
    

    
    public static void readRooms(){
        try {
            File gameData = new File("GameRooms.txt");
            Scanner fileReader = new Scanner(gameData);
            
            boolean inRoom = false;
            
            
            String[] identifiers = {"name","id","doors","description","canLeave","prompt","choices","responses","health","reward","doorOpens","repeatable","itemReq","win"};
            

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
                    for (int i=0;i<roomData.length;i++){
                        if (roomData[i]==null&&i<10){
                            allAccounted=false;
                        }
                        else if (roomData[i]!= null &&roomData[i].equals("null")){
                            roomData[i] = null;
                        }
                        else if(roomData[i]!=null&& roomData[i].contains("\\n")){
                            while (roomData[i].contains("\\n")) {
                                roomData[i] = roomData[i].substring(0,roomData[i].indexOf("\\n"))+"\n"+roomData[i].substring(roomData[i].indexOf("\\n")+2);
                            }
                        }
                        
                    }
                    
                    //create and add room if things are there
                    if (allAccounted){
                        if (roomData[5]==null){
                            rooms.add(new Room(
                            roomData[0],
                            Integer.parseInt(roomData[1]),
                            roomData[2],
                            roomData[3],
                            getBoolean(roomData[4]),
                            null
                            )
                        );
                        }
                        rooms.add(new Room(
                            roomData[0],
                            Integer.parseInt(roomData[1]),
                            roomData[2],
                            roomData[3],
                            getBoolean(roomData[4]),
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
            
            // //TESTING
            // System.out.println("a");
            // for (Room room:rooms) System.out.println(room.toString());
            // System.out.println("b");


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
            nums[i] = getBoolean(strs[i]);
        }

        return nums;
    }

    public static boolean getBoolean(String str){
        if (str.toLowerCase().equals("true")){
                return true;
        }
        return false;
    }

    public static String[] readArray(String str){
        if (str==null){

            return null;
        }
        
        String arrayString = str;
        String seperator = ";";

        ArrayList<String> formedArrayList = new ArrayList<>();

        while (arrayString.contains(seperator)) { 
            //adds to arrayList: if "null", adds null instead
            formedArrayList.add(
                arrayString.substring(0,arrayString.indexOf(seperator)));
            arrayString = arrayString.substring(arrayString.indexOf(seperator)+1);
        }

        formedArrayList.add(arrayString);

        




        //convert to array
        String[] formedArray = new String[formedArrayList.size()];
        for (int i=0;i<formedArray.length;i++){
            if (!formedArrayList.get(i).equals("null")){
                formedArray[i] = formedArrayList.get(i);
            }
            else{
                formedArray[i] = null;
            }
            
        }


        
        return formedArray;


    }
    


}
