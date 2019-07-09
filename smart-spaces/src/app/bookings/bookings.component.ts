import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormControl} from '@angular/forms';

import { BookingsServiceService } from '../bookings-service.service';



@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

  
  

 
  constructor(private myRoute: Router, private bookingsService:BookingsServiceService) { }

  ngOnInit() {
    console.log("in booking ngoninit");
  }

  book(warehouseId, Name, UserEmail, OwnerMail, UserMobileNumber, PartitionNumber, StartDate, EndDate,Cost,TotalCost)
  {
    console.log(warehouseId, Name, UserEmail, OwnerMail, UserMobileNumber, PartitionNumber, StartDate, EndDate,Cost,TotalCost);
    let obj={
    
      warehouseId : warehouseId,    
      customer_name : Name,
      customerMailId : UserEmail,
      customer_mobilenumber : UserMobileNumber,
      ownerMail : OwnerMail,
      partitionId : PartitionNumber,
      start_date : StartDate,
      end_date : EndDate,
      cost : Cost,
      total_cost : TotalCost
    }
    console.log("obj-------working");
    console.log(obj);
    this.bookingsService.postBooking(obj).subscribe();
    
    
    
    //.subscribe(obj=>{
    //   console.log("in booking1");
    //   console.log(obj);
    //   console.log("in booking2");
    // });
  }

  
}
