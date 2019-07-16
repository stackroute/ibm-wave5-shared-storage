import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecommendServiceService {

  constructor(private Http:HttpClient) { }
    
  // getRecommendationData(data): any{
  //   console.log("get Recommendation service is working");
  //   console.log("rrrr");
  //   console.log(`${data}`);
  //   return this.Http.get(`http://localhost:8082/api/v1/recommendation/allStorageUnit`);
  // }

  // getRecommendationData1(): any{
  //   console.log("Recommendation service is working");
  //    console.log("post Storage working!");
  //    return this.Http.post("http://localhost:8082/api/v1/recommendation/storage",  {responseType: 'text'});
  // }
    
getRecommendationData(): any{
  console.log("get Recommendation service is working....Seed data though");
  return this.Http.get(`http://localhost:3000/warehouse`);

}




getSearchResuls(area,sqft): any{
  console.log("get Recommendation service is working.... Neo4j Search Results");
  return this.Http.get(`http://localhost:8082/api/v1/recommendation/location/${area}/${sqft}`);

}

getRecomommendationByCity(){
  console.log(sessionStorage.getItem('userLocation'));
  let city = sessionStorage.getItem('userLocation');

  return this.Http.get(`http://localhost:8082/api/v1/recommendation/partof/${city}`);

}


getGuestUserRecommendations(area): any{
  console.log("get Recommendation service is working.... Neo4j");
  return this.Http.get(`http://localhost:8082/api/v1/recommendation/location/${area}`);

}

getBookedUserRecommendationSqft(): any{
  console.log("get recommendation SQFT is working...");
  return this.Http.get('http://localhost:8082/api/v1/recommendation/SqftRecommendation');
}





}
