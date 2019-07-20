import { Component, OnInit, Inject } from '@angular/core';


@Component({
  selector: 'app-dashboard-user',
  templateUrl: './dashboard-user.component.html',
  styleUrls: ['./dashboard-user.component.css']
})
export class DashboardUserComponent implements OnInit {
  loggedIn: any = null;
  role: any;
  name: any;
  phone: any;
  email: any;
  data: any;



  constructor() { }

  ngOnInit() {

    console.log("Dashboard User");







    // console.log(sessionStorage.getItem('name')+"Inside this damn thing .. user comp");
    // console.log(sessionStorage.getItem('mobile')+"Inside this damn thing .. user comp");
    // console.log(sessionStorage.getItem('mail')+"Inside this damn thing .. user comp");
    // console.log(sessionStorage.getItem('role')+"Inside this damn thing .. user comp");


    // this.name = sessionStorage.getItem('name');
    // this.phone = sessionStorage.getItem('mobile');
    // this.email = sessionStorage.getItem('mail');


    this.data = (JSON.parse(sessionStorage.getItem('details')));
    console.log(this.data);


    console.log(this.data.jti);
    console.log(this.data.sub);
    console.log(this.data.iss);
    console.log(this.data.aud);


    this.name = this.data.jti;
    this.phone = this.data.sub;
    this.email = this.data.iss;



    if (this.data.aud == "true") {
      this.role = "User"
    }


  }
}