import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { WarehouseServiceService } from '../warehouse-service.service';


@Component({
  selector: 'app-post-storage-unit',
  templateUrl: './post-storage-unit.component.html',
  styleUrls: ['./post-storage-unit.component.css']
})
export class PostStorageUnitComponent implements OnInit {

  numbers:Array<any> = [];
  val = 1;
  constructor(private myRoute: Router, private warehouseService: WarehouseServiceService) {
    
    console.log(this.val+"  : Inside Constructor...");
    this.numbers = Array.from({length:this.val},(v,k)=>k+1);
   
   }


   ngOnInit() {
  }


   add() {     
     this.val++;
     console.log(this.val);
     this.numbers = Array.from({length:this.val},(v,k)=>k+1);
   }

   delete() {   
     if(this.val>1)  {
    this.val--;
    console.log(this.val);
    this.numbers = Array.from({length:this.val},(v,k)=>k+1);
     }
  }


  postUnit(inputMail,nameWH,image,PlotNo,inputLocation,city,state,country,pincode,inputCost,inputArea){

    
    console.log(inputMail,nameWH,image,PlotNo,inputLocation,city,state,country,pincode);
    let obj = 
      {
        id: "50",
        name: nameWH,
        image_url: image,
        owner_mailid: inputMail,
        time_stamp: "sxxxs",
      
        address: {
            
                plotnumber: PlotNo,
              area: inputLocation,
             city: city,
             state: state,
             country:country,
              pincode: pincode
            },
          partitions:[
            {
                uuid: "1",
                type: "refrigerated",
                size: "123",
                cost: "123",
                tenant: {
                    name: "llll",
                    emailId: "cdd",
                    mobileNumber: "sss",
                    startDate: "sss",
                    lastDate: "sssss"
                }
            }],
        occupied_partitions: "3",
        total_sqft:"5"
      

    }
    console.log("Post Unit Working...");
    this.warehouseService.postWarehouse(obj).subscribe();




  }



}
