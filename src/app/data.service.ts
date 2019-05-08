import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Session } from './Models/session.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  Add_Teacher_URL = 'http://localhost:8080/Automated_Time_Table_Generator_WebApp/webresources/ATTG_API/Add_Teacher';
  Add_Room_URL = 'http://localhost:8080/Automated_Time_Table_Generator_WebApp/webresources/ATTG_API/Add_Room';
  Add_Course_URL = 'http://localhost:8080/Automated_Time_Table_Generator_WebApp/webresources/ATTG_API/Add_Course';
  Add_Session_URL = 'http://localhost:8080/Automated_Time_Table_Generator_WebApp/webresources/ATTG_API/Add_Session';
  
  Get_Teachers_URL = 'http://localhost:8080/Automated_Time_Table_Generator_WebApp/webresources/ATTG_API/Get_Teachers';
  Get_Rooms_URL = 'http://localhost:8080/Automated_Time_Table_Generator_WebApp/webresources/ATTG_API/Get_Rooms';
  Get_Courses_URL = 'http://localhost:8080/Automated_Time_Table_Generator_WebApp/webresources/ATTG_API/Get_Courses';
  Get_Table_URL = 'http://localhost:8080/Automated_Time_Table_Generator_WebApp/webresources/ATTG_API/Get_Table';

  constructor(private _http: HttpClient) { }

  Add_Teacher(TeacherData) {
    return this._http.post<any>(this.Add_Teacher_URL, TeacherData);
  }

  Add_Course(CourseData) {
    return this._http.post<any>(this.Add_Course_URL, CourseData);
  }

  Add_Room(RoomData) {
    return this._http.post<any>(this.Add_Room_URL, RoomData);
  }

  Add_Session(SessionData) {
    return this._http.post<any>(this.Add_Session_URL, SessionData);
  }

  GetTable() {
    return this._http.get<Session[]>(this.Get_Table_URL);
  }

}
