import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RecommendServiceService } from '../recommend-service.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  area: any;
  sqft: any;
  arrayOfData: any = [];

  constructor(private router: Router, private recommendationService: RecommendServiceService, private route: ActivatedRoute) { }

  ngOnInit() {

    console.log("Inside Search Result -- Guest User");
    const area = this.route.snapshot.paramMap.get('area');
    const sqft = this.route.snapshot.paramMap.get('sqft');
    console.log(area, sqft);

    this.recommendationService.getSearchResuls(area, sqft).subscribe(data => {
      this.arrayOfData = data;
      console.log(this.arrayOfData);
    });

    // Using Seed Data
    // this.recommendationService.getRecommendationData().subscribe(data=>
    //   {
    //    this.arrayOfData=data;
    //    console.log(this.arrayOfData);


    // });
  }


  details(data) {

    console.log(data);
    this.router.navigateByUrl("/details-guest/" + data);

  }

}
