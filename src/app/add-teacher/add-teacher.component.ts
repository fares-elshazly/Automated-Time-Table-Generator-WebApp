import { Component, OnInit} from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DataService } from '../data.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-teacher',
  templateUrl: './add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent implements OnInit {

  constructor(private DataService: DataService, private toastr: ToastrService) { }

  TeacherForm = new FormGroup({
    ID: new FormControl(''),
    Phone: new FormControl(''),
    Email: new FormControl('')
  });

  onTeacherSubmit() {
    this.DataService.Add_Teacher(this.TeacherForm.value).
    subscribe(
      response => this.toastr.success("You've Added Teacher Successfully!", "Success!"),
      error => this.toastr.error(error.error, "Error!")
    )
  }

  ngOnInit() {}

}
