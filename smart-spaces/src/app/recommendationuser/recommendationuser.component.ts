import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';

@Component({
  selector: 'app-recommendationuser',
  templateUrl: './recommendationuser.component.html',
  styleUrls: ['./recommendationuser.component.css']
})
export class RecommendationuserComponent implements OnInit {
  arrayOfData:any=[];

  constructor(private recommService:RecommendServiceService) { }

  ngOnInit() {

    console.log("I am here");
    this.recommService.getRecomommendationByCity().subscribe(data=>
      {
  
       this.arrayOfData=data;
       console.log(this.arrayOfData);
      
   
    });
  }
  }


