import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WarehouseServiceService {

  constructor(private Http: HttpClient) {

   }
 

  postWarehouse(obj): any {
    console.log("post Storage working ( Inside Service )");
    return this.Http.post("http://localhost:8100/api/v1/warehouse", obj, {responseType: 'text'});
  }

}
