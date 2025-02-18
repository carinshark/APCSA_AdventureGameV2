public class Item {
    private String name;
    private Player parent;
    private String text;
    private int uses;
    private int useHealth;
    private String useText;
    private int amount;

    public Item(String name,String text,int uses,int useHealth,String useText){
        this.name = name;
        this.text = text;
        this.uses = uses;
        this.useHealth = useHealth;
        this.useText = useText;
        this.amount = 1;


    }
    public Item(String name,String text,int uses,int useHealth,String useText,int amount){
        this.name = name;
        this.text = text;
        this.uses = uses;
        this.useHealth = useHealth;
        this.useText = useText;
        this.amount = amount;


    }

    public String getName(){
        return name;
    }
    public String getText(){
        return text;
    }
    public int getUses(){
        return uses;
    }

    public void setParent(Player parent){
        this.parent = parent;
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



}
