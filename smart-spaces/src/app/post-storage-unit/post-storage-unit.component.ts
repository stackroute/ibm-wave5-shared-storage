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
  area: number;
  @ViewChild('myCheck', { static: false }) el: ElementRef;

  constructor(private myRoute: Router, private warehouseService: WarehouseServiceService) { }

  ngOnInit() {}
  
  add(area, cost) {
    let partation = {
      pid: this.val,
      type: this.el.nativeElement.value,
      sqft: area,
      cost: cost
    }
    this.partitions.unshift(partation);
    this.sumArea = this.sumArea + parseInt(area);
    this.sumCost = this.sumCost + parseInt(cost);
    this.val++;
  }

  delete(partation) {
    this.sumArea = this.sumArea - partation.area
    this.sumCost = this.sumCost - partation.cost
    this.partitions = this.partitions.filter((e) => e.pid !== partation.pid)
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
    data.partitions = this.partitions
    console.log(data)
    // data.
    data.totalArea = this.sumArea;
    data.totalCost = this.sumCost;
    this.warehouseService.postWarehouse(data).subscribe();
  }

}

