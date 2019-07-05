import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private Http: HttpClient) { }
  obj: any;
  obj1;any;


  getToken(obj): any {
    console.log("get token working.. ");
    console.log(obj.emailId,obj.password);
    return this.Http.post(`http://localhost:8004/api/login`,obj);
  }

  registration(obj): Observable<any>{
    console.log("registartion working..");
    console.log(obj);
    return this.Http.post('http://localhost:8004/api/register',obj);
  }


  registrationOwner(obj1): Observable<any>{
    console.log("registartion working..");
    console.log(obj1);
    return this.Http.post('http://localhost:8004/api/register',obj1);
  }



  
}

