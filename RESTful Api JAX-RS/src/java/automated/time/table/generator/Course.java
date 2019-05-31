package automated.time.table.generator;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {

    private int ID;
    private String Name;
    private String Year;
    private int NumOfLectures;
    private int NumOfLabs;
    private ArrayList<Lecture> Lectures = new ArrayList<>();
    private ArrayList<Lab> Labs = new ArrayList<>();
    private Scanner Scan;

    Course() {
        Scan = new Scanner(System.in);
        ID = -1;
        Name = new String();
        Year = new String();
        NumOfLectures = 0;
        NumOfLabs = 0;
        Lectures = new ArrayList<>();
        Labs = new ArrayList<>();
    }
    
    Course(int ID, String Name, int NumOfLectures, int NumOfLabs) {
        this.ID = ID;
        this.Name = Name;
        this.NumOfLectures = NumOfLectures;
        this.NumOfLabs = NumOfLabs;
    }

    Course(int ID, String Name, int NumOfLectures, int NumOfLabs, ArrayList<Lecture> Lectures, ArrayList<Lab> Labs) {
        this.ID = ID;
        this.Name = Name;
        this.NumOfLectures = NumOfLectures;
        this.NumOfLabs = NumOfLabs;
        this.Lectures = Lectures;
        this.Labs = Labs;
    }

    public void GetCourseDetails() {
        System.out.print("Please Enter The Course ID : ");
        this.ID = Scan.nextInt();
        System.out.print("Please Enter The Course Name : ");
        this.Name = Scan.next();
        System.out.print("Please Enter The Course Student's Year : ");
        this.Year = Scan.next();
        System.out.print("Please Enter The Course Number Of Lectures : ");
        this.NumOfLectures = Scan.nextInt();
        for (int i = 1; i <= this.NumOfLectures; i++) {
            System.out.printf("Lecture %d Details\n", i);
            Lecture Lecture = new Lecture();
            Lecture.GetLectureDetails();
            Lecture.SetName(this.Name + " Lecture");
            Lecture.SetYear(this.Year);
            Lectures.add(Lecture);
        }
        System.out.print("Please Enter The Course Number Of Labs : ");
        this.NumOfLabs = Scan.nextInt();
        for (int i = 1; i <= this.NumOfLabs; i++) {
            System.out.printf("Lab %d Details\n", i);
            Lab Lab = new Lab();
            Lab.GetLabDetails();
            Lab.SetName(this.Name + " Lab");
            Lab.SetYear(this.Year);
            Labs.add(Lab);
        }
    }
    
    public void AddLecture(Lecture Lec) {
        this.Lectures.add(Lec);
    }
    
    public void AddLab(Lab Lab) {
        this.Labs.add(Lab);
    }

    public ArrayList<Lecture> GetLectures() {
        return Lectures;
    }

    public void SetLectures(ArrayList<Lecture> Lectures) {
        this.Lectures = Lectures;
    }

    public ArrayList<Lab> GetLabs() {
        return Labs;
    }

    public void SetLabs(ArrayList<Lab> Labs) {
        this.Labs = Labs;
    }

    public int GetID() {
        return ID;
    }

    public void SetID(int ID) {
        this.ID = ID;
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }
    
    

}
