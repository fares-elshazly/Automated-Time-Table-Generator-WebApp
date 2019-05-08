import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DataService } from '../data.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {

  constructor(private DataService: DataService, private toastr: ToastrService) { }

  SessionForm = new FormGroup({
    CourseID: new FormControl(''),
    TeacherID: new FormControl(''),
    RoomName: new FormControl(''),
    Type: new FormControl(''),
    Name: new FormControl(''),
    Year: new FormControl(''),
    Duration: new FormControl('')
  });

  onSessionSubmit() {
    this.DataService.Add_Session(this.SessionForm.value).
    subscribe(
      response => this.toastr.success("You've Added Session Successfully!", "Success!"),
      error => this.toastr.error(error.error, "Error!")
    )
  }

  ngOnInit() {}

}
