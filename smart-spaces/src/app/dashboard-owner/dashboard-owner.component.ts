import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';

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


  constructor(private myRoute: Router, private auth: AuthService, private route: ActivatedRoute) { }

  helper = new JwtHelperService();
  ngOnInit() {

    let obj = {
      emailId: this.route.snapshot.paramMap.get('mail'),
      password: this.route.snapshot.paramMap.get('pwd')
    }


    this.auth.getToken(obj).subscribe(data => {

      console.log("Heyyyyy from Dashboard Owner")
      if (data.token) {
        sessionStorage.setItem('token', data.token);
        sessionStorage.setItem('details', JSON.stringify(this.helper.decodeToken(data.token)));
        console.log(this.helper.decodeToken(data.token));


        let type = this.helper.decodeToken(data.token).aud;
        let mail = this.helper.decodeToken(data.token).iss;
        let name = this.helper.decodeToken(data.token).sub;

        console.log(type, "this is the role");
        console.log(mail, "this is the MailID");
        console.log(name, "this is the name");
        if (type == "false") {
          this.role = "Owner";
        }
        this.email = mail;
        this.name = name;

      }

    }, err => {
      this.loggedIn = true;
    })
  }

}
