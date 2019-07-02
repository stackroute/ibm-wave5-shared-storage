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
    console.log("get token working");
    return this.Http.post("http://localhost:8004/api/login", obj)
  }

  
}

