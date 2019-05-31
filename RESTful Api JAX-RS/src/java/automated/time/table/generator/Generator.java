package automated.time.table.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Generator {

    private final Scanner Scan;
    static int DayStart = 9;
    static int DayOff = 16;
    static ArrayList<Course> Courses = new ArrayList<>();
    static ArrayList<Room> Rooms = new ArrayList<>();
    static ArrayList<Teacher> Teachers = new ArrayList<>();
    static ArrayList<Lecture> Lectures = new ArrayList<>();
    static ArrayList<Lab> Labs = new ArrayList<>();
    static ArrayList<ArrayList<Session>> Table = new ArrayList<>();
    static ArrayList<String> WeekDays = new ArrayList<String>( 
                                                Arrays.asList("Sat", 
                                                              "Sun", 
                                                              "Mon",
                                                              "Tue",
                                                              "Wed",
                                                              "Thu")); 

    Generator() {
        Scan = new Scanner(System.in);
        Courses = new ArrayList<>();
        Rooms = new ArrayList<>();
        Teachers = new ArrayList<>();
        Lectures = new ArrayList<>();
        Labs = new ArrayList<>();
        Table = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Table.add(new ArrayList<>());
        }
    }

    public void GetCourses() {
        System.out.print("Please Enter The Number Of Courses : ");
        int NumOfCourses = Scan.nextInt();

        for (int i = 1; i <= NumOfCourses; i++) {
            System.out.printf("Course %d Details\n", i);
            Course Course = new Course();
            Course.GetCourseDetails();
            Courses.add(Course);
        }
    }

    public void GetRooms() {
        System.out.print("Please Enter The Number Of Rooms : ");
        int NumOfRooms = Scan.nextInt();

        for (int i = 1; i <= NumOfRooms; i++) {
            Room Room;
            System.out.printf("Room %d Details\n", i);
            System.out.print("Please Enter The Room Type (Class / Lab) : ");
            String Type = Scan.next();
            if (Type.equals("Class")) {
                Room = new ClassRoom();
            } else {
                Room = new Laboratory();
            }
            Room.GetRoomDetails();
            Rooms.add(Room);
        }
    }

    public void GetTeachers() {
        System.out.print("Please Enter The Number Of Teachers : ");
        int NumOfTeachers = Scan.nextInt();

        for (int i = 1; i <= NumOfTeachers; i++) {
            System.out.printf("Teacher %d Details\n", i);
            Teacher Teacher = new Teacher();
            Teacher.GetTeacherDetails();
            Teachers.add(Teacher);
        }
    }

    public static void Concatenate() {
        for (Course Course : Courses) {
            for (Lecture Lec : Course.GetLectures()) {
                Lectures.add(Lec);
            }
        }
        for (Course Course : Courses) {
            for (Lab Lab : Course.GetLabs()) {
                Labs.add(Lab);
            }
        }
    }

    public static void Sort() {
        Collections.sort(Lectures, new Sorting());
        Collections.sort(Labs, new Sorting());
    }

    public static void Process() {
        
        Lectures.clear();
        Labs.clear();
        Table.clear();
        
        for (int i = 0; i < 6; i++) {
            Table.add(new ArrayList<>());
        }
        
        Concatenate();
        Sort();
        
        Days:
        for (ArrayList<Session> List : Table) {
            for (int i = 0; i < Math.max(Lectures.size(), Labs.size()); i++) {

                if (i < Lectures.size()) {
                    int StartLec = DayStart;
                    int EndLec = DayStart + Lectures.get(i).GetDuration();

                    for (Session S : List) {
                        if (S.GetRoom().GetName().equals(Lectures.get(i).GetRoom().GetName())) {
                            StartLec = S.GetTo();
                            EndLec = S.GetTo() + Lectures.get(i).GetDuration();
                        } else if (S.GetTeacher().GetID() == Lectures.get(i).GetTeacher().GetID()) {
                            StartLec = S.GetTo();
                            EndLec = S.GetTo() + Lectures.get(i).GetDuration();
                        } else if (S.GetYear().equals(Lectures.get(i).GetYear())) {
                            StartLec = S.GetTo();
                            EndLec = S.GetTo() + Lectures.get(i).GetDuration();
                        }
                        if (StartLec + Lectures.get(i).GetDuration() > DayOff) {
                            continue Days;
                        }
                    }

                    Lectures.get(i).SetFrom(StartLec);
                    Lectures.get(i).SetTo(EndLec);
                    List.add(Lectures.get(i));
                    Lectures.remove(i);
                }

                if (i < Labs.size()) {
                    int StartLab = DayStart;
                    int EndLab = DayStart + Labs.get(i).GetDuration();
                    
                    for (Session S : List) {
                        if (S.GetRoom().GetName().equals(Labs.get(i).GetRoom().GetName())) {
                            StartLab = S.GetTo();
                            EndLab = S.GetTo() + Labs.get(i).GetDuration();
                        } else if (S.GetTeacher().GetID() == Labs.get(i).GetTeacher().GetID()) {
                            StartLab = S.GetTo();
                            EndLab = S.GetTo() + Labs.get(i).GetDuration();
                        } else if (S.GetYear().equals(Labs.get(i).GetYear())) {
                            StartLab = S.GetTo();
                            EndLab = S.GetTo() + Labs.get(i).GetDuration();
                        }
                        if (StartLab + Labs.get(i).GetDuration() > DayOff) {
                            continue Days;
                        }
                    }
                    
                    Labs.get(i).SetFrom(StartLab);
                    Labs.get(i).SetTo(EndLab);
                    List.add(Labs.get(i));
                    Labs.remove(i);
                }

            }
        }
        
        for (int i = 0; i < Table.size(); i++) {
                for (Session S : Table.get(i)) {
                    S.SetDay(WeekDays.get(i));
                }
        }
        
    }

    public void Display() {
        if (Lectures.size() > 0) {
            System.out.println("Sorry This Table is Impossible");
        } else {
            for (int i = 0; i < Table.size(); i++) {
                for (Session S : Table.get(i)) {
                    System.out.println(S.GetName());
                    System.out.println(i + " " + S.GetFrom() + " - " + S.GetTo());
                    System.out.println();
                }
            }
        }
    }

}
