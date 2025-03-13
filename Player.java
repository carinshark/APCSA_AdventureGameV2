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

    public Item getItem(String name){
        for (Item item:inventory){
            if (item.getName().toLowerCase().equals(name.toLowerCase())){
                return item;
            }
        }
        return null;
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

    public boolean hasItem(String id){
        for (Item i:inventory){
            if (i.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void removeItem(String id){
        for (int i=0;i<inventory.size();i++){
            if (inventory.get(i).getId().equals(id)){
                inventory.remove(i);
                break;
            }
        }
        System.err.println("ITEM TO REMOVE NOT FOUND:"+id);
    }

    //NO LONGER NEEDED
    // public boolean hasItem(String itemName){
    //     for (Item x:inventory){
    //         if (x.getName().equals(itemName)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public Room getLocation(){
        return location;
    }
    
    public void setLocation(Room location){
        this.location = location;
    }

    public void addHealth(int amount){
        health+= amount;
        if (health>100){
            health=100;
        } else if (health<0){
            health = 0;
        }
    }

}
