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

  constructor(private myRoute: Router, private auth: AuthService) { }

  ngOnInit() {
  }

  register(firstName,lastName,Password,confirmPassword,emailId,mobileNo,Role){
    console.log("register working...");
    console.log(firstName,lastName,Password,confirmPassword,emailId,mobileNo,Role);
    
    if(Role) {
      console.log("Owner");

    }
    else{
      console.log("User");
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
  console.log("qqqqq");
// this.auth.registration(obj).subscribe(data => {
//     console.log(data)

//   })

  }
}