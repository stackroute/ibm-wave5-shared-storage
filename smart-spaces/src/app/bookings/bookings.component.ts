import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { BookingsServiceService } from '../bookings-service.service';
import { WarehouseServiceService } from '../warehouse-service.service';


@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {
partitionData:any[];
data:any;
name:any;
phone:any;
email:any;
 
  constructor(private myRoute: Router, private whService:WarehouseServiceService,private route:ActivatedRoute) { }

  ngOnInit() {


    this.data = (JSON.parse(sessionStorage.getItem('details')));
    console.log(this.data);


    console.log(this.data.jti);
    console.log(this.data.sub);
    console.log(this.data.iss);
    console.log(this.data.aud);


    this.name = this.data.jti;
    this.phone = this.data.sub;
    this.email = this.data.iss;
  


    const myVal = this.route.snapshot.paramMap.get('id');
    this.whService.getWarehouseData(myVal).subscribe(data=>
      {
  
       this.partitionData=data;
       console.log(this.partitionData);
   
    });



  }
}
