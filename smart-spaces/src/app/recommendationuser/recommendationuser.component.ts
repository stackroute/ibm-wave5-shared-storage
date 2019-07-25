
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
    console.log("I am here.. values from recommendationsssss");
    this.recommService.getBookedUserRecommendationSqft().subscribe(data=>
      {
  
       this.arrayOfData=data;
      //  let uniquewarehouses = this.arrayOfData.map(e => {
      //    return e.warehouseName;
      //  })
      //  uniquewarehouses = uniquewarehouses.filter((e, i)=> uniquewarehouses.indexOf(e) === i);

      //  console.log(uniquewarehouses)
      //  this.arrayOfData = this.arrayOfData.map((e, i) => {
      //    if(uniquewarehouses.indexOf(e.warehouseName) !== -1) {
      //      console.log(e)
      //      let a = i + 1
      //      uniquewarehouses.splice(i,a)
      //      console.log(uniquewarehouses)
      //      return e
      //    }
      //  })
      //  this.arrayOfData = this.arrayOfData.filter(e => e !== undefined)
       console.log(this.arrayOfData);

       console.log ("The length is... "+data.length);
      
       if(data.length<= 0) {
         this.recommService.getRecomommendationByCity().subscribe(data=>
          {
      
           this.arrayOfData=data;
           console.log(this.arrayOfData);
           
       });
   
    }
  });
}

  details(wid) {

    console.log(wid);
    this.router.navigateByUrl("/details-book/" + wid);

  }
  }


