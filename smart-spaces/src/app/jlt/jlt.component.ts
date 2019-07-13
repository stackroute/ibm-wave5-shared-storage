import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-jlt',
  templateUrl: './jlt.component.html',
  styleUrls: ['./jlt.component.css']
})
export class JltComponent implements OnInit {

  val = 1;
  sumArea = 0;
  sumCost = 0;


  partitions: Array<any> = [];


  title = 'materialApp';
  one: FormGroup;
  two: FormGroup;
  three: FormGroup;



  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit() {


    this.one = this._formBuilder.group({


      nameCtrl: [],
      mailCtrl: [],
      phoneCtrl: [],
      whCtrl: []

      //  nameCtrl: ['', Validators.required],
      //  mailCtrl: ['', Validators.required],
      //  phoneCtrl: ['', Validators.required],
      //  whCtrl: ['', Validators.required],



    });
    this.two = this._formBuilder.group({


       plotNo :[],
       area: [],
       city: [],
       state:[],
       country:[],
       pincode :[]

      //  NumberCtrl: ['', Validators.required],
      //  AreaCtrl: ['', Validators.required],
      //  CityCtrl: ['', Validators.required],
      //  StateCtrl: ['', Validators.required],
      //  CountryCtrl: ['', Validators.required],
      //  PincodeCtrl: ['', Validators.required]

    });
    this.three = this._formBuilder.group({

      areaCtrl:[],
      pCostCtrl:[],
      // areaCtrl: ['', Validators.required],
      // pCostCtrl: ['', Validators.required],
      pType: [false]

    });

  }

  firstNext() {
    console.log("First Module Values...");
    console.log(this.one);
  }

  secondNext() {
    console.log("Second Module Values...");
    console.log(this.two.value);
  }

  thirdNext() {
    console.log("Third Module Values...");
    console.log(this.three);
  }



  add(sqft, cost) {

    console.log(this.three)
    console.log(this.three.controls.pType.value);

    let partitions = {
      pid: this.val,
      type: this.three.controls.pType.value,
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
    this.partitions = this.partitions.filter((e) => e.pid !== partitions.pid);
  }


  postSU()
  {

    let address = { 





    //   plotNo:data.plotNo,
    //  area:data.area,
    //  city:data.city,
    //  state:data.state,
    //  country:data.country,
    //  pincode:data.pincode
    }
    // data.ownerMail = this.email;

    // data.name = data.warehouseName;
 
    // data.address = address;

    // data.partitions = this.partitions;
    // console.log(data)
    // data.
    // data.totalArea = this.sumArea;
    // data.totalCost = this.sumCost;
    // this.warehouseService.postWarehouse(data).subscribe();
    // this.myRoute.navigateByUrl("/owner-dashboard");
  }

}



