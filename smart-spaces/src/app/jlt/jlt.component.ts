import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { WarehouseServiceService } from '../warehouse-service.service';


@Component({
  selector: 'app-jlt',
  templateUrl: './jlt.component.html',
  styleUrls: ['./jlt.component.css']
})
export class JltComponent implements OnInit {

  val = 0;
  sumArea = 0;
  sumCost = 0;


  partitions: Array<any> = [];
//Owner Data from JWT token
  ownerData:any;
  name:any;
  phone:any;
  email:any;


  one: FormGroup;
  two: FormGroup;
  three: FormGroup;



  // Fields

  address: any;


  constructor(private _formBuilder: FormBuilder, private warehouseService:WarehouseServiceService) { }

  ngOnInit() {


    this.ownerData = (JSON.parse(sessionStorage.getItem('details')));
    console.log(this.ownerData);


    console.log(this.ownerData.jti);
    console.log(this.ownerData.sub);
    console.log(this.ownerData.iss);
    console.log(this.ownerData.aud);
    this.name = this.ownerData.jti;
    this.phone = this.ownerData.sub;
    this.email = this.ownerData.iss;
  


    this.one = this._formBuilder.group({


      name: [{value:this.name,disabled:true}],
      ownerMail: [{value:this.email,disabled:true}],
      phone: [{value:this.phone,disabled:true}],
      warehouseName: [],
      imgUrl:[]


    });
    this.two = this._formBuilder.group({


      plotNo: [],
      area: [],
      city: [],
      state: [],
      country: [],
      pincode: []

    });
    this.three = this._formBuilder.group({

      areaCtrl: [],
      pCostCtrl: [],
      pType: [false],
      // tcost:[{disabled:true}],
      // tarea:[{disabled:true}]

    });

  }

  firstNext() {
    // console.log("First Module Values...");
    // console.log(this.one);
    // console.log(this.one.value.ownerMail);
  }

  secondNext() {
    // console.log("Second Module Values...");
    // console.log(this.two);
    this.address = this.two.value;
    // console.log(this.address);
  }

  thirdNext() {
    // console.log("Third Module Values...");
    // console.log(this.three);

    this.postSU();
  }



  add(sqft, cost) {

    this.val++;

    let partitions = {
      pid: this.val,
      type: this.three.controls.pType.value,
      sqft: sqft,
      cost: cost
    }
    this.partitions.unshift(partitions);
    this.sumArea = this.sumArea + parseInt(sqft);
    this.sumCost = this.sumCost + parseInt(cost);
  
  }


  delete(partitions) {
    this.sumArea = this.sumArea - partitions.sqft;
    this.sumCost = this.sumCost - partitions.cost;

    this.partitions = this.partitions.filter((e) => e.pid !== partitions.pid);

    // this.partitions =  this.partitions.map ((e => {

    //   if(e.pid > partitions.pid) {
    //     e.pid--;
    //     if(this.val<e.pid) {
    //     this.val = e.pid;
    //     }
    //   }

    //   return e;

    // }) 

// )
   
   
  }


  postSU() {
    console.log("Inside Post SU.....");
    console.log(this.address);
    console.log(this.one.value.ownerMail);
    let data = {

      ownerMail: this.email,
      warehouseName: this.one.value.warehouseName,
      address: this.address,
      partitions: this.partitions,
      totalArea: this.sumArea,
      totalCost: this.sumCost,
      imageUrl: this.one.value.imgUrl

    }



    console.log("The data to be sent to service...");
    console.log(data);

    this.warehouseService.postWarehouse(data).subscribe();




  }



}



