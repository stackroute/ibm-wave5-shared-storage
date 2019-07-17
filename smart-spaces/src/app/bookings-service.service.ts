import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment} from '../environments/environment';



@Injectable({
  providedIn: 'root'
})
export class BookingsServiceService {

  constructor(private Http: HttpClient) { }

  postBooking(obj): any {
    console.log("postBooking working");
    return this.Http.post(`${environment.booking}/api/v1/history`, obj,{responseType:'text'});

   }

   getBooking(mail): any {
    console.log("getBooking working"+mail);
    return this.Http.post(`${environment.booking}/api/v1/histories/${mail}`, {responseType:'text'});

   }

  //  /histories/{userMailId}
   
}