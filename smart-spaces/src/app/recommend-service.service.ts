import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecommendServiceService {

  constructor(private Http:HttpClient) { }


    
  getRecommendationData(data): any{
    console.log("get Recommendation service is working");
    console.log("Hgsuwhdhhhhhhhhhhhhhhhhhhh");
    console.log(`${data}`);
    return this.Http.get(`http://localhost:8082/api/v1/recommendation/allStorageUnit`);
}

}
