import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DataService } from '../data.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  constructor(private DataService: DataService, private toastr: ToastrService) { }

  CourseForm = new FormGroup({
    ID: new FormControl(''),
    Name: new FormControl(''),
    NumOfLectures: new FormControl(''),
    NumOfLabs: new FormControl('')
  });

  onCourseSubmit() {
    this.DataService.Add_Course(this.CourseForm.value).
    subscribe(
      response => this.toastr.success("You've Added Course Successfully!", "Success!"),
      error => this.toastr.error(error.error, "Error!")
    )
  }

  ngOnInit() {}

}
