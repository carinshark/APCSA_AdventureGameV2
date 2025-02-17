
import java.util.Scanner;

public class RoomWriter{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String roomValue = scan.nextLine();
        
        
        System.out.println(
            "//ROOM "+roomValue+"\nString[] c"+roomValue+" = {};\nString[] res"+roomValue+" = {};\nint[] h"+roomValue+" = {};\nItem[] rew"+roomValue+" = {};\nboolean[] rep"+roomValue+" = {};\nboolean[] doorOpens"+roomValue+" = {};\nItem[] req"+roomValue+" = null;\nboolean[] win"+roomValue+" = null;\nallRooms.add(new Room(NAME,"+roomValue+",DOORS,DESCRIPTION,\nnew Challenge( PROMPT, c"+roomValue+", res"+roomValue+", h"+roomValue+", rew"+roomValue+", doorOpens"+roomValue+", rep"+roomValue+", req"+roomValue+", win"+roomValue+"),LEAVE));"
        );


        scan.close();







    }
}