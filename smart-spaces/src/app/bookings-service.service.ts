import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class BookingsServiceService {

  constructor(private Http: HttpClient) { }

  postBooking(obj): any {
    console.log("postBooking working");
    return this.Http.post("http://localhost:8102/api/v1/history", obj,{responseType:'arraybuffer'});

   }
}