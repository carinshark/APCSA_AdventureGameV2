import java.util.ArrayList;

public class Player {
    private String name;
    private int health = 100;
    private ArrayList<Item> inventory;
    private Room location;


    public Player(String name,Room location){
        this.name = name;
        this.location = location;
        this.inventory = new ArrayList<Item>();
        
    }


    public boolean isAlive(){
        return (health>0);
    }
    public String getName(){
        return name;
    }
    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public Room getLocation(){
        return location;
    }
    
    public void setLocation(Room location){
        this.location = location;
    }

    public void addHealth(int amount){
        health+= amount;
    }

}
