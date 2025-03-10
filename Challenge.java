public class Challenge {
    // String type;

    private boolean isComplete = false;
    private String prompt;
    private String[] choices;
    private String[] responses;
    private int[] health;
    private String[] reward;
    private boolean[] openDoors;
    private boolean[] repeatable;
    private String[] itemReq;
    private boolean[] win;


    public Challenge(String prompt,String[] choices,String[] responses,int[] health,String[] reward,boolean[] openDoors,boolean[] repeatable,String[] itemReq,boolean[] win){
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

    public String toString(){
        String output = "";
        output+="isComplete:"+isComplete+"\n";
        output+="prompt:"+prompt+"\n";
        output+="choice:"+choices+"\n";
        output+="responses:"+responses+"\n";
        output+="health:"+health+"\n";
        output+="reward:"+reward+"\n";
        output+="openDoors:"+openDoors+"\n";
        output+="repeatable:"+repeatable+"\n";
        output+="itemReq:"+itemReq+"\n";
        output+="win:"+win+"\n";


        return output;
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
    public String[] getRewards(){
        return reward;
    }
    public boolean[] getOpenDoors(){
        return openDoors;
    }
    public boolean[] getRepeatable(){
        return repeatable;
    }
    public String[] getItemReq(){
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
