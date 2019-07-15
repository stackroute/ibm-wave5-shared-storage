import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';

@Component({
  selector: 'app-user-search-result',
  templateUrl: './user-search-result.component.html',
  styleUrls: ['./user-search-result.component.css']
})
export class UserSearchResultComponent implements OnInit {

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


