

public class Room {

    
    private String name;
    private int id;
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
    



}
