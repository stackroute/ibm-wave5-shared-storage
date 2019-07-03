import { Component, OnInit, Directive, Input } from '@angular/core';
import { Validator, NG_VALIDATORS, AbstractControl } from '@angular/forms';

@Component({
  selector: '[app]',
  templateUrl: './confirm-equal-password.component.html',
  styleUrls: ['./confirm-equal-password.component.css'],
  providers:[{
    provide: NG_VALIDATORS,
    useExisting: ConfirmEqualPasswordComponent,
    multi: true
  }]
})


export class ConfirmEqualPasswordComponent implements Validator {

  @Input() app: string;
  validate(control: AbstractControl): {[key:string]: any} | null{
    const controlToCompare = control.parent.get(this.app);
    if(controlToCompare && controlToCompare.value !== control.value){
      return { 'notEqual': true };
    }

    return null;

  } 

  

}
