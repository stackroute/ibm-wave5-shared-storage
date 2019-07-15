import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RecommendServiceService } from '../recommend-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private router:Router, private recommendationService : RecommendServiceService) { }
  sqft:any;
  area :any;
  ngOnInit() {

  
  }

  getData(area,sqft):any{
    console.log("in get data")
    console.log(area,sqft)
    this.area=area;
    this.sqft=sqft;
    this.recommendationService.getRecommendationData(this.area,this.sqft).subscribe(data=>
      {
        console.log("printing area and sqft")
       this.area=data;
       console.log(this.area);
      
    });
    
  }


}
