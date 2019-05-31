package automated.time.table.generator;
import java.util.Scanner;

public abstract class Room {

    private String Name;
    private String Type;
    Scanner Scan;

    Room() {
        Name = new String();
        Scan = new Scanner(System.in);
    }

    Room(String Name, String Type) {
        this.Name = Name;
        this.Type = Type;
    }

    public void GetRoomDetails() {
        System.out.print("Please Enter The Room Name : ");
        this.Name = Scan.next();
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }

    public String GetType() {
        return Type;
    }

    public void SetType(String Type) {
        this.Type = Type;
    }
    
    

}
