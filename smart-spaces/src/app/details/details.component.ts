import { Component, OnInit } from '@angular/core';
import { WarehouseServiceService } from '../warehouse-service.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  ArrayOfPartionData: any = [];
  constructor(private warehouseService:WarehouseServiceService) { }

  ngOnInit() {

    this.warehouseService.getWarehouseData().subscribe(data=>
      {
      console.log("listed-storage working,,,,,,")
      console.log(data);
       this.ArrayOfPartionData=data;
       console.log(this.ArrayOfPartionData);
       console.log("")
    });
  }

}
