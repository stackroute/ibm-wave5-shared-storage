import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.css']
})
export class RecommendationsComponent implements OnInit {
  details: any[];
  constructor() {
    this.details=[{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},
    {location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"}];
 }

  ngOnInit() {
  }

}
