import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {
  details: any[];

  constructor() { 

    this.details=[{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},
    {location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"}];
  }

  ngOnInit() {
  }

}