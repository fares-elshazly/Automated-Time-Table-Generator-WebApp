package automated.time.table.generator;

import java.util.Scanner;

public abstract class Session {

    Scanner Scan;
    private String Name;
    private String Year;
    private int Duration;
    private String Day;
    private int From;
    private int To;
    private Teacher Teacher;
    private Room Room;

    Session() {
        Scan = new Scanner(System.in);
        Name = new String();
        Year = new String();
        Day = new String();
        Teacher = null;
        Room = null;
        Duration = -1;
        From = -1;
        To = -1;
    }

    Session(String Name, String Year, Teacher Teacher, Room Room, int Duration) {
        this.Name = Name;
        this.Year = Year;
        Day = new String();
        From = -1;
        To = -1;
        this.Teacher = Teacher;
        this.Room = Room;
        this.Duration = Duration;
    }

    public Teacher GetTeacher() {
        return Teacher;
    }

    public void SetTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }

    public Room GetRoom() {
        return Room;
    }

    public void SetRoom(Room Room) {
        this.Room = Room;
    }

    public int GetDuration() {
        return Duration;
    }

    public void SetDuration(int Duration) {
        this.Duration = Duration;
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }

    public String GetYear() {
        return Year;
    }

    public void SetYear(String Year) {
        this.Year = Year;
    }

    public String GetDay() {
        return Day;
    }

    public void SetDay(String Day) {
        this.Day = Day;
    }
    
    

    public int GetFrom() {
        return From;
    }

    public void SetFrom(int From) {
        this.From = From;
    }

    public int GetTo() {
        return To;
    }

    public void SetTo(int To) {
        this.To = To;
    }

}
