import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recommendationguest',
  templateUrl: './recommendationguest.component.html',
  styleUrls: ['./recommendationguest.component.css']
})
export class RecommendationguestComponent implements OnInit {
  arrayOfData:any=[];

  constructor(private recommService:RecommendServiceService,private router: Router) { }

  ngOnInit() {

    this.recommService.getRecomommendationByCity().subscribe(data=>
      {
  
       this.arrayOfData=data;
       console.log(this.arrayOfData);
      
   
    });
  }

  details(wid) {
    console.log(wid);
    this.router.navigateByUrl("/details-guest/" + wid);

    
  }
  }

