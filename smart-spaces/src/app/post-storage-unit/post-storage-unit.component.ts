import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Router } from '@angular/router';

import { WarehouseServiceService } from '../warehouse-service.service';




@Component({
  selector: 'app-post-storage-unit',
  templateUrl: './post-storage-unit.component.html',
  styleUrls: ['./post-storage-unit.component.css']
})
export class PostStorageUnitComponent implements OnInit {

  numbers: Array<any> = [];
  partitions: Array<any> = [];
  val = 1;
  sumCost = 0;
  sumArea = 0;
  size: number;
  sqft: number;
  form1:any;
  @ViewChild('myCheck', { static: false }) el: ElementRef;

  name:any;
  phone:any;
  email:any;
  data1:any;

  constructor(private myRoute: Router, private warehouseService: WarehouseServiceService) { }

  ngOnInit() {

    this.data1 = (JSON.parse(sessionStorage.getItem('details')));
    console.log(this.data1);


    console.log(this.data1.jti);
    console.log(this.data1.sub);
    console.log(this.data1.iss);
    console.log(this.data1.aud);
    this.name = this.data1.jti;
    this.phone = this.data1.sub;
    this.email = this.data1.iss;
  
  }
  
  add(sqft, cost) {
    let partitions = {
      pid: this.val,
      type: this.el.nativeElement.value,
      sqft: sqft,
      cost: cost
    }
    this.partitions.unshift(partitions);
    this.sumArea = this.sumArea + parseInt(sqft);
    this.sumCost = this.sumCost + parseInt(cost);
    this.val++;
  }

  delete(partitions) {
    this.sumArea = this.sumArea - partitions.sqft;
    this.sumCost = this.sumCost - partitions.cost
    this.partitions = this.partitions.filter((e) => e.pid !== partitions.pid)
  }

  toggle() {
    if (this.el.nativeElement.value == "false") {

      this.el.nativeElement.value = true;
    } else {
      this.el.nativeElement.value = false;

    }
    console.log("here at toggle", this.el.nativeElement.value)

  }

  postUnit(data) {
    let address = {
      plotNo:data.plotNo,
     area:data.area,
     city:data.city,
     state:data.state,
     country:data.country,
     pincode:data.pincode
    }
    data.ownerMail = this.email;

    data.name = data.warehouseName;
 
    data.address = address;

    data.partitions = this.partitions;
    console.log(data)
    // data.
    data.totalArea = this.sumArea;
    data.totalCost = this.sumCost;
    this.warehouseService.postWarehouse(data).subscribe();
    this.myRoute.navigateByUrl("/owner-dashboard");
  }

}

