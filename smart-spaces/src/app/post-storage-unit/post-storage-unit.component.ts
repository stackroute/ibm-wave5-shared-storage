import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
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

  sumCost = 0;
  sumArea = 0;
  partitions:any=[];

 size: number;
 area:number;
 
 



  @ViewChild('myCheck', {static: false}) el: ElementRef ;


  

  constructor(private myRoute: Router, private warehouseService: WarehouseServiceService) {
    
    console.log(this.val+"  : Inside Constructor...");
    this.numbers = Array.from({length:this.val},(v,k)=>k+1);
   
   }


   ngOnInit() {
  }


   add(area,cost) {    
     
    // this.save(area,cost);
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
          partitions:this.partitions,
          sqft: this.sumArea,
          totalCost:this.sumCost
           

    }
    console.log("Post Unit Working...", this.el.nativeElement.value);
    console.log("Total Area and Sum   ",obj.sqft,obj.totalCost);

    // this.warehouseService.postWarehouse(obj).subscribe();

    for(var i=0;i< this.val;i++){
      console.log("Partition loop..."+ obj.partitions[i].uuid,obj.partitions[i].cost,obj.partitions[i].type,obj.partitions[i].size,);
     
    }
  }

  save(inputCost,inputArea){
    
     let partition = {
        uuid: this.val,
        type: this.el.nativeElement.value,
        size: inputArea,
        cost: inputCost,
      }

      this.sumCost = this.sumCost + 12 
      this.sumArea = this.sumArea + 13 
     
      this.partitions[partition.uuid-1] = partition;
      console.log(inputArea);
      console.log(  this.partitions[partition.uuid-1].uuid, this.partitions[partition.uuid-1].type, this.partitions[partition.uuid-1].size,this.partitions[partition.uuid-1].cost+"  Save Function");


     
    }


 



}
