import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-owner',
  templateUrl: './dashboard-owner.component.html',
  styleUrls: ['./dashboard-owner.component.css']
})
export class DashboardOwnerComponent implements OnInit {
  loggedIn: any = null;
  role: any;
  name: any;
  phone: any;
  email: any;


  data: any;

  constructor() { }

  ngOnInit() {

    console.log("Dashboard Owner");



    // console.log(sessionStorage.getItem('name') + "Inside this damn thing .. Owner comp");
    // console.log(sessionStorage.getItem('mobile') + "Inside this damn thing .. Owner comp");
    // console.log(sessionStorage.getItem('mail') + "Inside this damn thing .. Owner comp");
    // console.log(sessionStorage.getItem('role') + "Inside this damn thing .. Owner comp");

    this.data = (JSON.parse(sessionStorage.getItem('details')));
    console.log(this.data);


    console.log(this.data.jti);
    console.log(this.data.sub);
    console.log(this.data.iss);
    console.log(this.data.aud);



    this.name = this.data.jti;
    this.phone = this.data.sub;
    this.email = this.data.iss;



    if (this.data.aud == "false") {
      this.role = "Owner"
    }




  }
}