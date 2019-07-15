import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {
  area:any;
  sqft:any;
  arrayOfData:any=[];
  
    constructor( private router:Router, private recommendationService : RecommendServiceService) { }
  
    ngOnInit() {

    
    //  this.recommendationervice.getRecommendationData(this.data).subscribe(data=>

    // // console.log(this.mail);
    // //  this.recommendationervice.getRecommendationData(this.mail).subscribe(data=>
    //     {
    
    //      this.arrayOfData=data;
    //      console.log(this.arrayOfData);
     
    //   });

    

      //  this.recommendationervice.getRecommendationData1().subscribe(data=>
      //   {
    
        //  this.arrayOfData=data;
        //  console.log(this.arrayOfData);
     
      // });


      // this.recommendationService.getRecommendationData().subscribe(data=>
      //   {
    
      //    this.area=data;
      //    console.log(this.area);
        
     
      // });

      this.recommendationService.getSearchResuls(this.area,this.sqft).subscribe(data=>
        {
          this.area=data;
          console.log(this.area);

        });
    
  
    }
 
  }      
    
  
  
    
  
          
    
  
  
  