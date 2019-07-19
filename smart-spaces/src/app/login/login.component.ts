import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { MatDialog } from '@angular/material';

import { DashboardUserComponent } from '../dashboard-user/dashboard-user.component';
import { ModalUserComponent } from '../modal-user/modal-user.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  inputName: any;
  inputEmail: any;
  loggedIn: any = null;
  loggedOut: any = null;

  constructor(private myRoute: Router, private auth: AuthService, private dialog:MatDialog ) { }

  helper = new JwtHelperService();
  ngOnInit() {
  }

  login(email, pwd) {

    console.log("login working");
    let obj = {
      emailId: email,
      password: pwd
    }
    console.log(obj);
    this.auth.getToken(obj).subscribe(data => {
      console.log(data)
      console.log("hiiii")
      if (data.token) {

        sessionStorage.setItem('data',data);
        sessionStorage.setItem('token', data.token);
        sessionStorage.setItem('details', JSON.stringify(this.helper.decodeToken(data.token)));
        console.log(this.helper.decodeToken(data.token));
        let type = this.helper.decodeToken(data.token).aud;
        console.log(type, "this is the role")
        


    
        sessionStorage.setItem('name', this.helper.decodeToken(data.token).jti);
        sessionStorage.setItem('mobile', this.helper.decodeToken(data.token).sub);
        sessionStorage.setItem('mail', this.helper.decodeToken(data.token).iss);
        sessionStorage.setItem('role', this.helper.decodeToken(data.token).aud);
        
     
        console.log(sessionStorage.getItem('name')+"Inside this damn thing");
  
   

      
        if (type == "true") {

          if(parseInt(sessionStorage.getItem('pid')) > 0 ) {
            this.myRoute.navigateByUrl("bookbyid/"+sessionStorage.getItem('wid')+"/"+sessionStorage.getItem('pid'));
          }
          else {
          this.myRoute.navigateByUrl("/recommendationUser");
          }
        
        }

       if(type == "false") {
          this.myRoute.navigateByUrl("/listed-storage");
          
        }
      }


    }, err => {
      this.loggedIn = true;
    })
  }
  logoutUser() {
    console.log("logout working..");
    this.myRoute.navigateByUrl('/logout');
    console.log("routing...")
    return sessionStorage.removeItem('token');
  }
}
