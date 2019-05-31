package automated.time.table.generator;

public class Lecture extends Session {

    private Teacher Teacher;
    private Room Room;
    private boolean Found;

    Lecture() {
        super();
        Teacher = new Teacher();
        Room = new ClassRoom();
    }

    Lecture(String Name, String Year, Teacher Teacher, Room Room, int Duration) {
        super(Name, Year, Teacher, Room, Duration);
    }

    public void GetLectureDetails() {
        Found = false;

        do {
            System.out.print("Please Enter The Teacher ID : ");
            int ID = Scan.nextInt();
            for (Teacher Holder : Generator.Teachers) {
                if (Holder.GetID() == ID) {
                    Teacher = Holder;
                    Found = true;
                    break;
                }
            }
            if (!Found) {
                System.out.println("Sorry This Teacher ID Doesn't Exist! Please Try Again ..");
            }
        } while (!Found);

        Found = false;

        do {
            System.out.print("Please Enter The Room Name : ");
            String Name = Scan.next();

            for (Room Holder : Generator.Rooms) {
                if (Holder.GetName().equals(Name)) {
                    Room = Holder;
                    Found = true;
                    break;
                }
            }
            if (!Found) {
                System.out.println("Sorry This Room Name Doesn't Exist! Please Try Again ..");
            }
        } while (!Found);

        System.out.print("Please Enter The Lecture Number Of Hours : ");
        int Duration = Scan.nextInt();

        this.SetTeacher(Teacher);
        this.SetRoom(Room);
        this.SetDuration(Duration);

    }
}
