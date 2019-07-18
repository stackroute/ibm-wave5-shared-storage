import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

 
  constructor(private Http: HttpClient) { }

    
  getListedData(mail): any{
      console.log("get listedData service is working");
    return this.Http.get(`${environment.userprofile}/api/v1/getbookings/${mail}`);


  }


  getBookedData(mail):any {
    console.log("get Booked data service is working");
    return this.Http.get(`${environment.userprofile}/api/v1/getbookings/${mail}`);

  }
}
