import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { WarehouseServiceService } from '../warehouse-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DatePipe } from '@angular/common';
import * as moment from 'moment';
import { BookingsServiceService } from '../bookings-service.service';



@Component({
  selector: 'app-booking-new',
  templateUrl: './booking-new.component.html',
  styleUrls: ['./booking-new.component.css']
})
export class BookingNewComponent implements OnInit {


  partitionData: any[];
  data: any;
  name: any;
  phone: any;
  email: any;
  ownerMail: any;
  pid: any;
  cost: any;
  sqft: any;
  partId: any
  location: any;
  wid: any;
  startDate: any;
  endDate: any;
  wname: any;

  calcMonth: any;

  arrayDate1: any = [];
  arrayDate2: any = [];

  myGroup: FormGroup;


  userData: any;

  constructor(private date: DatePipe, private myRoute: Router, private whService: WarehouseServiceService, private route: ActivatedRoute, private bookingService: BookingsServiceService, private _formBuilder: FormBuilder, private warehouseService: WarehouseServiceService) { }


  ngOnInit() {


    this.userData = (JSON.parse(sessionStorage.getItem('details')));
    console.log(this.userData);


    console.log(this.userData.jti);
    console.log(this.userData.sub);
    console.log(this.userData.iss);
    console.log(this.userData.aud);

    this.name = this.userData.jti;
    this.phone = this.userData.sub;
    this.email = this.userData.iss;


    const myVal = this.route.snapshot.paramMap.get('id');
    this.pid = this.route.snapshot.paramMap.get('pid');
    this.wid = myVal;
    console.log("Justlike that..." + this.wid);


    this.whService.getWarehouseData(myVal).subscribe(data => {

      console.log(data)


      this.partitionData = data;
      this.wname = data.warehouseName;
      console.log(this.partitionData);
      this.ownerMail = data.ownerMail;
      this.partId = parseInt(this.pid) - 1;
      console.log(this.partId + "PartIDddddddddddddddddd");
      console.log(data.partitions[this.partId].cost);
      console.log(data.partitions[this.partId].sqft);
      this.location = data.address.area;

      console.log((data.partitions.length)+"Length of array");

      this.cost = (data.partitions[((data.partitions.length)-this.partId)-1].cost);
      this.sqft = (data.partitions[((data.partitions.length)-this.partId)-1].sqft);



      console.log("Justlike that..." + this.wname);


      console.log("Values..." + this.wname, this.cost, this.sqft, this.wid);





    });

    console.log("Values..." + this.wname, this.partId, this.sqft, this.wid);



    this.myGroup = this._formBuilder.group({

      uName: [{ value: this.userData.jti, disabled: false }],
      uEmail: [{ value: this.userData.iss, disabled: false }],
      phone: [{ value: this.userData.sub, disabled: false }],
      wid: [{ value: this.wid, disabled: false }],

      wname: [{ value: this.wname, disabled: false }],

      partitionNo: [{ value: this.partId, disabled: false }],
      cost: [{ value: this.cost, disabled: false }],
      ownerMail: [{ value: this.ownerMail, disabled: false }],
      sqft: [{ value: this.sqft, disabled: false }]
      // totalCost:[]



    });



  }


  BookNow(date1, date2) {

    console.log("Book Now works...", moment, new Date(date1), date2);
    let start = moment(date1);
    let end = moment(date2);
    let dif = end.diff(start, 'days');
    let months = Math.round(dif / 30);
    this.calcMonth = months;

    console.log(months, dif, "this is Moment Formatted Date")
    let obj = {
      bookingIdentity: {
        warehouseId: this.wid,
        pid: this.pid
      },
      userName: this.name,
      userMailId: this.email,
      userMobile: this.phone,
      ownerMail: this.ownerMail,
      sqft: this.sqft,
      location: this.location,
      startDate: start,
      endDate: end,
      cost: this.cost,
      totalCost: this.cost * this.calcMonth
    }

    console.log(obj);

    this.bookingService.postBooking(obj).subscribe();
    this.myRoute.navigateByUrl("/thanksBook");
    // this.myRoute.navigateByUrl("/user-dashboard");  
  }
}