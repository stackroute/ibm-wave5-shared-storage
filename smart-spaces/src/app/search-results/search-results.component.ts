import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {
  mail : any;
  data:any;
  arrayOfData: any = [] ;
  
    constructor( private router:Router, private recommendationervice : RecommendServiceService) { }
  
    ngOnInit() {

    console.log(this.data);
     this.recommendationervice.getRecommendationData(this.data).subscribe(data=>

    console.log(this.mail));
    //  this.recommendationervice.getRecommendationData(this.mail).subscribe(data=>
    //     {
    
    //      this.arrayOfData=data;
    //      console.log(this.arrayOfData);
     
    //   });



       this.recommendationervice.getRecommendationData1().subscribe(data=>
        {
    
         this.arrayOfData=data;
         console.log(this.arrayOfData);
     
      });



    
    }
  
  
    details(data){
  
      console.log(data);
      this.router.navigateByUrl("/details-book/"+data);
          
    }
  
  }
  