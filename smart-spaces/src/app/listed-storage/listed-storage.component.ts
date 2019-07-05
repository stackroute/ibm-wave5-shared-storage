import { Component, OnInit } from '@angular/core';
import { WarehouseServiceService } from '../warehouse-service.service';
import { UserProfileService } from '../user-profile.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listed-storage',
  templateUrl: './listed-storage.component.html',
  styleUrls: ['./listed-storage.component.css']
})
export class ListedStorageComponent implements OnInit {
  ArrayOfWarehouseData : any = [];
  constructor(private warehouseService:WarehouseServiceService,private upService:UserProfileService, private router:Router) { }
  data:any;
  ngOnInit() {
    this.upService.getListedData().subscribe(data=>
      {
  
       this.ArrayOfWarehouseData=data;
       console.log(this.ArrayOfWarehouseData);
   
    });
  
    //Using json
    
    // this.warehouseService.getWarehouseData().subscribe(data=>
    //   {
    //   console.log("listed-storage working,,,,,,")
    //   console.log(data);
    //    this.ArrayOfWarehouseData=data;
    //    console.log(this.ArrayOfWarehouseData);
    //    console.log("")
    // });
  }
  details(data){

    console.log(data);
    this.router.navigateByUrl("/details/"+data);




  }
}
