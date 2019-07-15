import { Component, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';


@Component({
  selector: 'app-modal-user',
  templateUrl: './modal-user.component.html',
  styleUrls: ['./modal-user.component.css']
})
export class ModalUserComponent implements OnInit {
  location:any;

  constructor(public dialogRef: MatDialogRef<ModalUserComponent>) { }

  ngOnInit() {
  }

  buttonClick(value){

    this.location = value;

    sessionStorage.setItem('userLocation',value);

    console.log("Session Storage" +sessionStorage.getItem('userLocation'));
  }


}
