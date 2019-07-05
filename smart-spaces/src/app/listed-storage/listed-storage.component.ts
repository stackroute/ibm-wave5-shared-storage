import { Component, OnInit } from '@angular/core';
import { WarehouseServiceService } from '../warehouse-service.service';

@Component({
  selector: 'app-listed-storage',
  templateUrl: './listed-storage.component.html',
  styleUrls: ['./listed-storage.component.css']
})
export class ListedStorageComponent implements OnInit {
  ArrayOfWarehouseData : any = [];
  constructor(private warehouseService:WarehouseServiceService) { }
  data:any;
  ngOnInit() {
    this.warehouseService.getWarehouseData().subscribe(data=>
      {
      console.log("listed-storage working,,,,,,")
      console.log(data);
       this.ArrayOfWarehouseData=data;
       console.log(this.ArrayOfWarehouseData);
       console.log("")
     });
  }
  details(data){

        
  }
}
