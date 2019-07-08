import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecommendServiceService {

  constructor(private Http:HttpClient) { }


    
  getRecommendationData(): any{
    console.log("Recommendation service is working");
 
    return this.Http.get(`http://localhost:3000/warehouse`);
}

}
