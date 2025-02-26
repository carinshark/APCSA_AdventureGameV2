
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Item {

    //all items in game
    private static ArrayList<Item> items = new ArrayList<Item>();



    private String name;
    private String id;
    private Player parent;
    private String text;
    private int uses;
    private int useHealth;
    private String useText;
    private int amount;

    public Item(String name,String id,String text,int uses,int useHealth,String useText){
        this.name = name;
        this.id = id;
        this.text = text;
        this.uses = uses;
        this.useHealth = useHealth;
        this.useText = useText;
        this.amount = 1;

    }

    public Item(String name,String id,String text,int uses,int useHealth,String useText,int amount){
        this.name = name;
        this.id = id;
        this.text = text;
        this.uses = uses;
        this.useHealth = useHealth;
        this.useText = useText;
        this.amount = amount;

    }
    public Item(Item i){
        this.name = i.getName();
        this.id = i.getId();
        this.text = i.getText();
        this.uses = i.getUses();
        this.useHealth = i.getUseHealth();
        this.useText = i.useText;
        this.amount = i.amount;
    }

    //getters
    public String getName()
    {return name;}
    public String getId()
    {return id;}
    public String getText()
    {return text;}
    public int getUses()
    {return uses;}
    public int getUseHealth()
    {return useHealth;}
    public String getUseText()
    {return useText;}
    public String getAmount()
    {return amount;}

    // setters
    public void setParent(Player parent)
    {this.parent = parent;}

    

    public void use(){
        if (uses==0){
            System.out.println("This item cannot be used!");
        }
        else{
            if (uses>0){
                uses--;
            }
            if (useHealth!=0){
                parent.addHealth(useHealth);
                System.out.println(useHealth+" hp");
            }
            

            if (useText!= null){
                System.out.println(useText);
            }
        }
    }

    public static Item createItem(String itemId){
        for (Item i:items){
            if item.getId.equals(itemID){
                return new Item(i);
            }
        }
    }

    public static void readItems(){
        try {
            File gameData = new File("GameItems.txt");
            Scanner fileReader = new Scanner(gameData);
            int braceDelimiter = 0;
            int quotationDelimiter = 0;
            String currentThing;
            while (fileReader.hasNextLine()) { 
                System.out.println(fileReader.nextLine());
                
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("GAME DATA MISSING!!!!!!!!!(Gameitems.txt)");
            e.printStackTrace();
        }
    }



}
