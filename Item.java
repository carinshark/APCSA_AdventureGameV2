
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.print.attribute.standard.Sides;

public class Item {

    //all items in game
    private static ArrayList<Item> items = new ArrayList<Item>();



    private String name;
    private final String id;
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
    public int getAmount()
    {return amount;}

    // setters
    public void setParent(Player parent)
    {this.parent = parent;}


    public void printInfo(){
        System.out.println(name);
        System.out.println(text);
        if (uses>0){
            System.out.println("Uses:"+uses);            
        } else if (uses==-1){
            System.out.println("can be used infinitely.");
        }

    }
    

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
            if (i.getId().equals(itemId)){
                return new Item(i);
            }
        }
        return null;
    }

    public static void readItems(){
        try {
            File gameData = new File("GameItems.txt");
            Scanner fileReader = new Scanner(gameData);
            
            boolean inItem = false;
            String[] itemData = new String[7];
            
            while (fileReader.hasNextLine()) { 
                String currentLine = fileReader.nextLine();
                
                if (currentLine.equals("{")&&!inItem){
                    inItem = true;
                    itemData = new String[7];

                }
                else if(currentLine.equals("}")&&inItem){
                    inItem = false;
                    boolean allAccounted = true;
                    for (int i=0;i<6;i++){
                        if (itemData[i]==null){
                            allAccounted=false;
                        }
                    }
                    if (allAccounted){
                        if (itemData[6]==null){
                            items.add(new Item(
                                itemData[0],
                                itemData[1],
                                itemData[2],
                                Integer.parseInt(itemData[3]),
                                Integer.parseInt(itemData[4]),
                                itemData[5]
                                ));
                        } else{
                            items.add(new Item(
                                itemData[0],
                                itemData[1],
                                itemData[2],
                                Integer.parseInt(itemData[3]),
                                Integer.parseInt(itemData[4]),
                                itemData[5],
                                Integer.parseInt(itemData[6])
                                ));
                        }
                    }
                    else{
                        System.err.println("THINGS ARE MISSING!");
                    }



                }
                else if (inItem){
                    if (currentLine.contains("name:")){
                        itemData[0] = currentLine.substring(currentLine.indexOf("name:")+5);
                    }
                    else if (currentLine.contains("id:")){
                        itemData[1] = currentLine.substring(currentLine.indexOf("id:")+3);
                    }
                    else if (currentLine.contains("text:")){
                        itemData[2] = currentLine.substring(currentLine.indexOf("text:")+5);
                    }
                    else if (currentLine.contains("uses:")){
                        itemData[3] = currentLine.substring(currentLine.indexOf("uses:")+5);
                    }
                    else if (currentLine.contains("useHealth:")){
                        itemData[4] = currentLine.substring(currentLine.indexOf("useHealth:")+10);
                    }
                    else if (currentLine.contains("useText:")){
                        itemData[5] = currentLine.substring(currentLine.indexOf("useText:")+8);
                    }
                    else if (currentLine.contains("amount:")){
                        itemData[6] = currentLine.substring(currentLine.indexOf("amount:")+7);
                    }
                }
                

                
                


                
            }
            
            //FOR TESTING PURPOSES
            // for(Item i:items){
            //     i.printInfo();
            // }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("GAME DATA MISSING!!!!!!!!!(Gameitems.txt)");
            e.printStackTrace();
        }
    }



}
