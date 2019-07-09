import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';

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

  constructor(private myRoute: Router, private auth: AuthService) { }

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
        sessionStorage.setItem('token', data.token);
   
        sessionStorage.setItem('details', JSON.stringify(this.helper.decodeToken(data.token)));
        console.log(this.helper.decodeToken(data.token));

        let type = this.helper.decodeToken(data.token).aud;
        console.log(type, "this is the role")
      
        if (type == "true") {
          this.myRoute.navigateByUrl("/recommendation/"+email+"/"+pwd);
        }
       if(type == "false") {
          this.myRoute.navigateByUrl("/listed-storage/"+email+"/"+pwd);

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
