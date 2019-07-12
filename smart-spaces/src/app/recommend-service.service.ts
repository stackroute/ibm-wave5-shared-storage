import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecommendServiceService {

  constructor(private Http:HttpClient) { }

<<<<<<< HEAD
 
    
  getRecommendationData(data): any{
    console.log("get Recommendation service is working");
    console.log("rrrr");
    console.log(`${data}`);
    return this.Http.get(`http://localhost:8082/api/v1/recommendation/allStorageUnit`);
=======



  getRecommendationData(): any{
    console.log("Recommendation service is working");
     console.log("post Storage working!");
     return this.Http.post("http://localhost:8082/api/v1/recommendation/storage",  {responseType: 'text'});

   }




    
getRecommendationData1(): any{
  console.log("get Recommendation service is working....Seed data though");

  return this.Http.get(`http://localhost:3000/warehouse`);
>>>>>>> f76fb78c1e84c9864d0399f59190d2cc06d78918
}


}


