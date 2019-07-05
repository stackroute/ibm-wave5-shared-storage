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
  @ViewChild('myCheck', { static: false }) el: ElementRef;

  constructor(private myRoute: Router, private warehouseService: WarehouseServiceService) { }

  ngOnInit() {}
  
  add(sqft, cost) {
    let partition = {
      pid: this.val,
      type: this.el.nativeElement.value,
      sqft: sqft,
      cost: cost
    }
    this.partitions.unshift(partition);
    this.sumArea = this.sumArea + parseInt(sqft);
    this.sumCost = this.sumCost + parseInt(cost);
    this.val++;
  }

  delete(partition) {
    this.sumArea = this.sumArea - partition.sqft;
    this.sumCost = this.sumCost - partition.cost
    this.partitions = this.partitions.filter((e) => e.pid !== partition.pid)
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
    let address ={
      plotNo:data.plotNo,
     area:data.area,
     city:data.city,
     state:data.state,
     country:data.country,
     pincode:data.pincode
    }

    data.name = data.warehouseName;
 
    data.address = address;

    data.partitions = this.partitions
    console.log(data)
    // data.
    data.totalArea = this.sumArea;
    data.totalCost = this.sumCost;
    this.warehouseService.postWarehouse(data).subscribe();
  }

}

