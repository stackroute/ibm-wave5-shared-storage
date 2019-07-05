import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

 
  constructor(private Http: HttpClient) { }

    
  getListedData(): any{
      console.log("get listedData service is working");
      return this.Http.get("http://localhost:8005/api/v1/getallpartition");
  }
}
