public class Challenge {
    // String type;

    private boolean isComplete = false;
    private String prompt;
    private String[] choices;
    private String[] responses;
    private int[] health;
    private Item[] reward;
    private boolean[] openDoors;
    private boolean[] repeatable;
    private Item[] itemReq;
    private boolean[] win;


    public Challenge(String prompt,String[] choices,String[] responses,int[] health,Item[] reward,boolean[] openDoors,boolean[] repeatable,Item[] itemReq,boolean[] win){
        this.prompt = prompt;
        this.choices = choices;
        this.responses = responses;
        this.health = health;
        this.reward = reward;
        this.openDoors = openDoors;
        this.repeatable = repeatable;
        this.itemReq = itemReq;
        this.win = win;
        
    }

    public String getPrompt(){
        return  prompt;
    }
    public String[] getChoices(){
        return choices;
    }
    public String[] getResponses(){
        return responses;
    }
    public int[] getHealth(){
        return health;
    }
    public Item[] getRewards(){
        return reward;
    }
    public boolean[] getOpenDoors(){
        return openDoors;
    }
    public boolean[] getRepeatable(){
        return repeatable;
    }
    public Item[] getItemReq(){
        return itemReq;
    }
    public boolean[] getWin(){
        return win;
    }
    public boolean isComplete(){
        return isComplete;
    }
    public void complete(){
        isComplete = true;
    }




}
