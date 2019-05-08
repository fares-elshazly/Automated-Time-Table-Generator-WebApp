import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DataService } from '../data.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent implements OnInit {

  constructor(private DataService: DataService, private toastr: ToastrService) { }

  RoomForm = new FormGroup({
    Type: new FormControl(''),
    Name: new FormControl(''),
  });

  onRoomSubmit() {
    this.DataService.Add_Room(this.RoomForm.value).
    subscribe(
      response => this.toastr.success("You've Added Room Successfully!", "Success!"),
      error => this.toastr.error(error.error, "Error!")
    )
  }

  ngOnInit() {}

}
