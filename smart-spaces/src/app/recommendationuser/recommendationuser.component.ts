import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recommendationuser',
  templateUrl: './recommendationuser.component.html',
  styleUrls: ['./recommendationuser.component.css']
})
export class RecommendationuserComponent implements OnInit {
  arrayOfData:any=[];

  constructor(private recommService:RecommendServiceService, private router:Router) { }

  ngOnInit() {
    console.log("I am here");
    this.recommService.getRecomommendationByCity().subscribe(data=>
      {
  
       this.arrayOfData=data;
       console.log(this.arrayOfData);
      
   
    });
  }

  details(wid) {

    console.log(wid);
    this.router.navigateByUrl("/details-book/" + wid);

  }
  }


