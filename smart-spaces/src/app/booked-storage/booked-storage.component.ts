import { Component, OnInit } from '@angular/core';




@Component({
  selector: 'app-booked-storage',
  templateUrl: './booked-storage.component.html',
  styleUrls: ['./booked-storage.component.css']
})
export class BookedStorageComponent implements OnInit {
  
  details: any[];
  constructor() {

    this.details=[{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"},
    {location:"bng",warehousename:"abc",Area:"1000sqft"},{location:"bng",warehousename:"abc",Area:"1000sqft"}];
  
  }
   
  ngOnInit() {
    
    
  }

}
