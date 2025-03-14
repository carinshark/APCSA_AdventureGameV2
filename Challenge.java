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
        output+="choice:"+getArrayString(choices)+"\n";
        output+="responses:"+getArrayString(responses)+"\n";
        output+="health:"+getArrayString(health)+"\n";
        output+="reward:"+getArrayString(reward)+"\n";
        output+="openDoors:"+getArrayString(openDoors)+"\n";
        output+="repeatable:"+getArrayString(repeatable)+"\n";
        output+="itemReq:"+getArrayString(itemReq)+"\n";
        output+="win:"+getArrayString(win)+"\n";


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

    public static String getArrayString(String[] arrayStrings){
        if (arrayStrings==null){
            return "null(real)"+",";
        }
        String outpuString = "";
        outpuString+= "[";

        for (String str:arrayStrings){
            if (str==null){
            outpuString+= "null(real)"+",";
        } else{
            outpuString+= str+",";
        }
        }
        outpuString = outpuString.substring(0,outpuString.length()-1);


        outpuString += "]";

        return outpuString;
    }

    public static String getArrayString(int[] arrayStrings){
        if (arrayStrings==null){
            return null;
        }
        String outpuString = "";
        outpuString+= "[";
        for (int str:arrayStrings){
            outpuString+= str+",";
        }
        outpuString = outpuString.substring(0,outpuString.length()-1);

        outpuString += "]";

        return outpuString;
    }

    public static String getArrayString(boolean [] arrayStrings){
        if (arrayStrings==null){
            return null;
        }
        String outpuString = "";
        outpuString+= "[";
        for (boolean str:arrayStrings){
            outpuString+= str+",";
        }
        outpuString = outpuString.substring(0,outpuString.length()-1);

        outpuString += "]";

        return outpuString;
    }




}
