import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-jlt',
  templateUrl: './jlt.component.html',
  styleUrls: ['./jlt.component.css']
})
export class JltComponent implements OnInit {


   title = 'materialApp';
   one: FormGroup;
   two: FormGroup;
   three: FormGroup;

   

   constructor(private _formBuilder: FormBuilder) { }
   ngOnInit() {
      this.one = this._formBuilder.group({
         nameCtrl: ['', Validators.required],
         mailCtrl: ['', Validators.required],
         phoneCtrl: ['', Validators.required],
         whCtrl: ['', Validators.required]
      });
      this.two = this._formBuilder.group({
         NumberCtrl: ['', Validators.required],
         AreaCtrl: ['', Validators.required],
         CityCtrl: ['', Validators.required],
         StateCtrl: ['', Validators.required],
         CountryCtrl: ['', Validators.required],
         PincodeCtrl: ['', Validators.required]

      });
      this.three = this._formBuilder.group({
        
      });
   }
   // spaceId: any;
   // spaceName: any;
   // category: any;
   // price: any;
   // height: any;
   // width: any;
   // buildingNumber: any;
   // area: any;
   // city: any;
   // state: any;
   // country: any;
   // pincode: any;


   // saveDetails(spaceId, spaceName, category, price, height, width, buildingNumber, area, city, state, country, pincode) {
   //    let obj = [
   //       spaceId = spaceId,
   //       spaceName = spaceName,
   //       category = category,
   //       price = price,
   //       height = height,
   //       width = width,
   //       buildingNumber = buildingNumber,
   //       area = area,
   //       city = city,
   //       state = state,
   //       country = country,
   //       pincode = pincode]


   //    console.log(obj);

   // }

}



