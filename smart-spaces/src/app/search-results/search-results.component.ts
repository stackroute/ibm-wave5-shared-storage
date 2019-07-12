import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {
 
  arrayOfData: any = [] ;
  
    constructor( private router:Router, private recommendationervice : RecommendServiceService) { }
  
    ngOnInit() {
  
     this.recommendationervice.getRecommendationData().subscribe(data=>
       {
       console.log(data);
       console.log("Trying to print the details.....");
    
         this.arrayOfData=data;
         console.log(this.arrayOfData);
     
      });
    
    }
  
  
    details(data){
  
      console.log(data);
      this.router.navigateByUrl("/details-book/"+data);
          
    }
  
  }
  