import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ModalUserComponent } from '../modal-user/modal-user.component';


@Component({
  selector: 'app-app-landing',
  templateUrl: './app-landing.component.html',
  styleUrls: ['./app-landing.component.css']
})
export class AppLandingComponent implements OnInit {

  constructor(private dialog: MatDialog) { }

  ngOnInit() {
    console.log("Landing page.....");

    //Modal Code .....

    const dialogRef = this.dialog.open(ModalUserComponent, {
      width: '945px',

    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}
