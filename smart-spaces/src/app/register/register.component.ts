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
<<<<<<< HEAD
=======
  console.log("qqqqq");
// this.auth.registration(obj).subscribe(data => {
//     console.log(data)
>>>>>>> d8d6938d799343c9a2f17e5724c60c5f49a59565

  this.myRoute.navigateByUrl('/login')

  }
}