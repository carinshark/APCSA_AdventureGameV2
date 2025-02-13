import java.util.ArrayList;

public class Player {
    String name;
    int health;
    ArrayList<Item> inventory = new ArrayList<Item>();
    Room location;


    public Player(String name,Room location){

    }


    public boolean isAlive(){
        return (health>0);
    }

}
