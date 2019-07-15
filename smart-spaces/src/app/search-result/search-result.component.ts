import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RecommendServiceService } from '../recommend-service.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {

  arrayOfData:any=[];

  constructor( private router:Router, private recommendationervice : RecommendServiceService) { }

  ngOnInit() {


    this.recommendationervice.getRecommendationData().subscribe(data=>
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
