import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DataService } from './data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'ANG-ATTG';

  constructor(private DataService: DataService) {}

  CourseForm = new FormGroup({
    ID: new FormControl(''),
    Name: new FormControl(''),
    NumOfLectures: new FormControl(''),
    NumOfLabs: new FormControl('')
  });

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.CourseForm.value);
    this.DataService.Add_Course(this.CourseForm.value)
                    .subscribe(
                      response => console.log('Success!', response),
                      error => console.error('Error', error)
                    );
  }


}
