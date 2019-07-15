import { Component, OnInit } from '@angular/core';
import { RecommendServiceService } from '../recommend-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-search-result',
  templateUrl: './user-search-result.component.html',
  styleUrls: ['./user-search-result.component.css']
})
export class UserSearchResultComponent implements OnInit {

  arrayOfData:any=[];

  constructor(private recommService:RecommendServiceService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit() {

    console.log("Inside Search Result -- Guest User");
    const area = this.route.snapshot.paramMap.get('area');
    const sqft = this.route.snapshot.paramMap.get('sqft');
    console.log(area, sqft);

    this.recommService.getSearchResuls(area, sqft).subscribe(data => {
      this.arrayOfData = data;
      console.log(this.arrayOfData);
    });


    // this.recommService.getRecomommendationByCity().subscribe(data=>
    //   {
  
    //    this.arrayOfData=data;
    //    console.log(this.arrayOfData);
      
   
    // });
  }


  details(data) {

    console.log(data);
    this.router.navigateByUrl("/details-book/" + data);

  }




  }


