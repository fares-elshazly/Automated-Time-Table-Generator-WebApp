package automated.time.table.generator;

public class AutomatedTimeTableGenerator {

    public static void main(String[] args) {
        Generator G = new Generator();
        G.GetTeachers();
        G.GetRooms();
        G.GetCourses();
        G.Concatenate();
        G.Sort();
        G.Process();
        G.Display();
    }

}
