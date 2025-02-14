import java.util.ArrayList;

public class Player {
    private String name;
    private int health;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private Room location;


    public Player(String name,Room location){

    }


    public boolean isAlive(){
        return (health>0);
    }

    public Room getLocation(){
        return location;
    }

}
