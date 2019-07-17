import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment} from '../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class WarehouseServiceService {


  constructor(private Http: HttpClient) {

   }
 

  postWarehouse(obj): any {
    console.log("post Storage working ( Inside Service )");
    return this.Http.post(`${environment.warehouse}/api/v1/warehouse`, obj, {responseType: 'text'});
  }



  
  getWarehouseData(val): any{
      console.log("get ware house data is working");
      console.log(`${val}`);
      return this.Http.get(`${environment.warehouse}/api/v1/oneWarehouse/${val}`);
  }

}
