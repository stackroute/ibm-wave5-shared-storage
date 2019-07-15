import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';

@Component({
  selector: 'app-recommendationguest',
  templateUrl: './recommendationguest.component.html',
  styleUrls: ['./recommendationguest.component.css']
})
export class RecommendationguestComponent implements OnInit {
  arrayOfData:any=[];

  constructor(private recommService:RecommendServiceService) { }

  ngOnInit() {

    this.recommService.getRecomommendationByCity().subscribe(data=>
      {
  
       this.arrayOfData=data;
       console.log(this.arrayOfData);
      
   
    });
  }
  }

