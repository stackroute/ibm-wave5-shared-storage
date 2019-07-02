import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Router } from '@angular/router';

import { WarehouseServiceService } from '../warehouse-service.service';
import { flatten } from '@angular/compiler';


@Component({
  selector: 'app-post-storage-unit',
  templateUrl: './post-storage-unit.component.html',
  styleUrls: ['./post-storage-unit.component.css']
})
export class PostStorageUnitComponent implements OnInit {

  numbers:Array<any> = [];
  val = 1;
  @ViewChild('myCheck', {static: false}) el: ElementRef ;

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

  toggle() {
    if (this.el.nativeElement.value == "false") {
      
      this.el.nativeElement.value = true;
    }else {
      this.el.nativeElement.value = false;

    }
    console.log("here at toggle", this.el.nativeElement.value)

  }

  postUnit(inputMail,nameWH,image,PlotNo,inputLocation,city,state,country,pincode,inputCost,inputArea,refrigerated){

    
    console.log(inputMail,nameWH,image,PlotNo,inputLocation,city,state,country,pincode,refrigerated,inputArea,inputCost);
    let obj =   {
        id: "53",
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
                type: refrigerated,
                size: inputArea,
                cost: inputCost,
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
    console.log("Post Unit Working...", this.el.nativeElement.value);
    // this.warehouseService.postWarehouse(obj).subscribe();




  }



}
