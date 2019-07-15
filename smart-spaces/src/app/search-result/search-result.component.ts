import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RecommendServiceService } from '../recommend-service.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  area:any;
  sqft:any;
  arrayOfData:any=[];

  constructor( private router:Router, private recommendationService : RecommendServiceService) { }

  ngOnInit() {


    this.recommendationService.getRecommendationData().subscribe(data=>
      {
  
       this.area=data;
       console.log(this.area);
      
   
    });
  }


  details(data){
  
    console.log(data);
    this.router.navigateByUrl("/details-book/"+data);
        
  }

}
