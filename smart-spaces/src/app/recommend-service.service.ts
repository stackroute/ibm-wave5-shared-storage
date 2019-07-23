import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment} from '../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class RecommendServiceService {

  constructor(private Http:HttpClient) { }
 

getSearchResuls(area,sqft): any{
  console.log("get Recommendation service is working.... Neo4j Search Results");
  return this.Http.get(`${environment.recommendation}/api/v1/recommendation/location/${area}/${sqft}`);

}

getRecomommendationByCity(){
  console.log(sessionStorage.getItem('userLocation'));
  let city = sessionStorage.getItem('userLocation');

  return this.Http.get(`${environment.recommendation}/api/v1/recommendation/partof/${city}`);

}


getGuestUserRecommendations(area): any{
  console.log("get Recommendation service is working.... Neo4j");
  return this.Http.get(`${environment.recommendation}/api/v1/recommendation/location/${area}`);

}

getBookedUserRecommendationSqft(): any{
  console.log("get recommendation SQFT is working...");
  return this.Http.get(`${environment.recommendation}/api/v1/recommendation/SqftRecommendation`);
}





}
