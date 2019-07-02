import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private Http: HttpClient) { }
  obj: any;


  getToken(obj): any {
    console.log("get token working.. ");
    console.log(obj.emailId,obj.password);
    return this.Http.post(`http://localhost:8004/api/login`,obj);
  }

  registration(obj): any{
    console.log("registartion working..");
    return this.Http.post(`http://localhost:8004/api/register`,obj);
  }

  
}

