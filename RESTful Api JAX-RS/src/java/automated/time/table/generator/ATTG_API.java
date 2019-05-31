package automated.time.table.generator;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("ATTG_API")
public class ATTG_API {

    @Context
    private UriInfo context;

    public ATTG_API() {

    }
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response IsWorking() {
        JSONObject JO = new JSONObject();
        JO.put("Hello", "World");
        return Response.status(200).entity(JO.toString()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Add_Teacher")
    public Response Add_Teacher(String Teacher) {
        JSONObject JO = new JSONObject(Teacher);
        Teacher T = new Teacher(JO.getInt("ID"), JO.getString("Phone"), JO.getString("Email"));
        for(Teacher TE : Generator.Teachers) {
            if(TE.GetID() == JO.getInt("ID")) {
                return Response.status(400).entity("Sorry But, The Entered Teacher ID Was Found!").build();
            }
        }
        Generator.Teachers.add(T);
        return Response.status(200).entity(JO.toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Get_Teachers")
    public Response Get_Teachers() {
        Teacher T = Generator.Teachers.get(0);
        JSONArray JArray = new JSONArray();
        for (Teacher TE : Generator.Teachers) {
            JSONObject JObject = new JSONObject();
            JObject.put("ID", TE.GetID());
            JObject.put("Phone", TE.GetPhoneNumber());
            JObject.put("Email", TE.GetEmail());
            JArray.put(JObject);
        }
        String Result = JArray.toString();
        return Response.status(200).entity(Result).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Add_Room")
    public Response Add_Room(String Room) {
        JSONObject JO = new JSONObject(Room);
        Room R;
        for(Room RO : Generator.Rooms) {
            if(RO.GetName().equals(JO.getString("Name"))) {
                return Response.status(400).entity("Sorry But, The Entered Room Name Was Found!").build();
            }
        }
        if (JO.getString("Type").equals("Class")) {
            R = new ClassRoom(JO.getString("Name"), JO.getString("Type"));
        } else {
            R = new Laboratory(JO.getString("Name"), JO.getString("Type"));
        }
        Generator.Rooms.add(R);
        return Response.status(200).entity(JO.toString()).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Get_Rooms")
    public Response Get_Rooms() {
        JSONArray JArray = new JSONArray();
        for (Room R : Generator.Rooms) {
            JSONObject JObject = new JSONObject();
            JObject.put("Name", R.GetName());
            JObject.put("Type", R.GetType());
            JArray.put(JObject);
        }
        String Result = JArray.toString();
        return Response.status(200).entity(Result).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Add_Course")
    public Response Add_Course(String Course) {
        JSONObject JO = new JSONObject(Course);
        Course C = new Course(JO.getInt("ID"), JO.getString("Name"), JO.getInt("NumOfLectures"), JO.getInt("NumOfLabs"));
        for(Course CO : Generator.Courses) {
            if(CO.GetID() == JO.getInt("ID")) {
                return Response.status(400).entity("Sorry But, The Entered Course ID Was Found!").build();
            }
        }
        Generator.Courses.add(C);
        return Response.status(200).entity(JO.toString()).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Add_Session")
    public Response Add_Session(String Session) {
        Course Course = null;
        Teacher Teacher = null;
        Room Room = null;
        JSONObject JO = new JSONObject(Session);
        
        for(Course C : Generator.Courses) {
            if(C.GetID() == JO.getInt("CourseID")) {
                Course = C;
                break;
            }
        }
        
        for(Teacher T : Generator.Teachers) {
            if(T.GetID() == JO.getInt("TeacherID")) {
                Teacher = T;
                break;
            }
        }
        
        for(Room R : Generator.Rooms) {
            if(R.GetName().equals(JO.getString("RoomName"))) {
                Room = R;
                break;
            }
        }
        
        if(Course == null || Teacher == null || Room == null) {
            return Response.status(400).entity("Sorry But, You Need To Type Correct Inputs!").build();
        }
        
        if(JO.getString("Type").equals("Lecture")) {
            Lecture Lecture = new Lecture(JO.getString("Name"), JO.getString("Year"), Teacher, Room, JO.getInt("Duration"));
            Course.AddLecture(Lecture);
        } else {
            Lab Lab = new Lab(JO.getString("Name"), JO.getString("Year"), Teacher, Room, JO.getInt("Duration"));
            Course.AddLab(Lab);
        }
        
        return Response.status(200).entity(JO.toString()).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Get_Courses")
    public Response Get_Courses() {
        JSONArray JArray = new JSONArray();
        for (Course C : Generator.Courses) {
            JSONObject JObject = new JSONObject();
            JObject.put("ID", C.GetID());
            JObject.put("Name", C.GetName());
            for(Lecture Lec : C.GetLectures()) {
                JObject.put("Lecture", Lec.GetName());
            }
            for(Lab Lab : C.GetLabs()) {
                JObject.put("Lab", Lab.GetName());
            }
            JArray.put(JObject);
        }
        String Result = JArray.toString();
        return Response.status(200).entity(Result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Get_Table")
    public Response Get_Table() {
        Generator.Process();
        JSONArray JArray = new JSONArray();
        for(ArrayList<Session> List : Generator.Table) {
            for(Session S : List) {
                JSONObject JObject = new JSONObject();
                JObject.put("Year", S.GetYear());
                JObject.put("Name", S.GetName());
                JObject.put("Day", S.GetDay());
                JObject.put("From", S.GetFrom());
                JObject.put("To", S.GetTo());
                JObject.put("Teacher", S.GetTeacher().GetID());
                JObject.put("Room", S.GetRoom().GetName());
                JArray.put(JObject);
            }
        }
        String Result = JArray.toString();
        return Response.status(200).entity(Result).build();
    }

}
