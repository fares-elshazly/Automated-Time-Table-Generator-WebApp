package automated.time.table.generator;
import java.util.Comparator;

public class Sorting implements Comparator<Session> {
    public int compare(Session A, Session B) 
    { 
        return A.GetDuration() - B.GetDuration(); 
    }
}
