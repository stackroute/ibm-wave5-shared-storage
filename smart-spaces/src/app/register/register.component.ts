import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  firstName:string;
  lastName:string;
  Password:any;
  confirmPassword:any;
  emailId:any;
  mobileNo:any;
  Role:any;
  registeredIn: any = null;

  constructor(private myRoute: Router, private auth: AuthService) { }

  ngOnInit() {
  }

  register(firstName,lastName,Password,confirmPassword,emailId,mobileNo,Role){
    console.log("registration working...");
    console.log(firstName,lastName,Password,confirmPassword,emailId,mobileNo,Role);
    
    if(Role) {
      console.log("User");

    }
    else{
      console.log("Owner");
    }

    let obj = {
      firstName: firstName,
      lastName: lastName,
      password: Password,
      emailId: emailId,
      mobileNo: mobileNo,
      role: Role
    }
  console.log(obj);


  this.auth.registration(obj).subscribe();

  this.myRoute.navigateByUrl('/login')

  }
}