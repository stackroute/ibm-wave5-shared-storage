import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-stepper',
  templateUrl: './stepper.component.html',
  styleUrls: ['./stepper.component.css']
})
export class StepperComponent implements OnInit {


  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;



  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit() {
  
      this.firstFormGroup = this._formBuilder.group({
        nameCtrl: ['', Validators.required],
        mailCtrl: ['', Validators.required],
        phoneCtrl: ['', Validators.required],
        whCtrl: ['', Validators.required],
        
         HeightCtrl: ['', Validators.required],
         WidthCtrl: ['', Validators.required]
      });
      this.secondFormGroup = this._formBuilder.group({
         NumberCtrl: ['', Validators.required],
         AreaCtrl: ['', Validators.required],
         CityCtrl: ['', Validators.required],
         StateCtrl: ['', Validators.required],
         CountryCtrl: ['', Validators.required],
         PincodeCtrl: ['', Validators.required]

      });
      this.thirdFormGroup = this._formBuilder.group({
         AmenitiesCtrl: ['', Validators.required]
      });
   }
  }
