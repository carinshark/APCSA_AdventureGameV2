import java.util.ArrayList;

public class Player {
    private String name;
    private int health = 100;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private Room location;


    public Player(String name,Room location){
        this.name = name;
        this.location = location;
    }


    public boolean isAlive(){
        return (health>0);
    }

    public Room getLocation(){
        return location;
    }
    
    public void setLocation(Room location){
        this.location = location;
    }

}
