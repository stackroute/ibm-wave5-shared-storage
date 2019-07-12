import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecommendServiceService {

  constructor(private Http:HttpClient) { }




  getRecommendationData(): any{
    console.log("Recommendation service is working");
     console.log("post Storage working!");
     return this.Http.post("http://localhost:8082/api/v1/recommendation/storage",  {responseType: 'text'});

   }




    
getRecommendationData1(): any{
  console.log("get Recommendation service is working....Seed data though");

  return this.Http.get(`http://localhost:3000/warehouse`);
}


}


