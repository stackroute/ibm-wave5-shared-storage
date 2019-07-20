import { Component, OnInit } from '@angular/core';
import { UserProfileService } from '../user-profile.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BookingsServiceService } from '../bookings-service.service';
import * as moment from 'moment';



@Component({
  selector: 'app-booked-storage',
  templateUrl: './booked-storage.component.html',
  styleUrls: ['./booked-storage.component.css']
})
export class BookedStorageComponent implements OnInit {

  mail: any;
  ArrayOfWarehouseData: any = [];
  constructor(private upService: UserProfileService, private router: Router) { }
  data: any;
  area: any;
  ngOnInit() {

    this.area = sessionStorage.getItem('userLocation');





    this.mail = (JSON.parse(sessionStorage.getItem('details')).iss);
    console.log(this.mail);
    this.upService.getBookedData(this.mail).subscribe(data => {

      console.log(data);
      this.ArrayOfWarehouseData = data;
      console.log(this.ArrayOfWarehouseData);
      this.ArrayOfWarehouseData.bookedStorageUnit = this.ArrayOfWarehouseData.bookedStorageUnit.map(e => {
        e.startDate = moment(e.startDate).format("DD-MMM-YYYY");
        e.endDate = moment(e.endDate).format("DD-MMM-YYYY");
        return e
      })
    });


  }
  details(data) {

    console.log(data);
    this.router.navigateByUrl("/details-book/" + data);

  }
}
