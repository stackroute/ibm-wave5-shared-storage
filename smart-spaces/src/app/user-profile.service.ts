import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

 
  constructor(private Http: HttpClient) { }

    
  getListedData(mail): any{
      console.log("get listedData service is working");
      return this.Http.get(`http://localhost:8005/api/v2/getlisted/${mail}`);
  }


  getBookedData(mail):any {
    console.log("get Booked data service is working");
    return this.Http.get(`http://localhost:8005/api/v1/getbookings/${mail}`);

  }
}
