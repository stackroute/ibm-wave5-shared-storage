import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import {startWith,map } from 'rxjs/operators';


export interface StateGroup {
  letter: string;
  names: string[];
}

export const _filter = (opt: string[], value: string): string[] => {
  const filterValue = value.toLowerCase();

  return opt.filter(item => item.toLowerCase().indexOf(filterValue) === 0);
};




@Component({
  selector: 'app-autocomplete',
  templateUrl: './autocomplete.component.html',
  styleUrls: ['./autocomplete.component.css']
})
export class AutocompleteComponent implements OnInit {


  stateForm: FormGroup = this._formBuilder.group({
    stateGroup: '',
  });

  stateGroups: StateGroup[] = [{
    letter: 'A',
    names: ['Andhra Pradesh', 'Arunachal Pradesh', 'Assam']
  }, {
    letter: 'B',
    names: ['Bihar']
  }, {  
    letter: 'C',
  names: ['Chattisgarh']
}, {  
  letter: 'G',
names: ['Goa','Gujarat']
}, {  
  letter: 'H',
names: ['Haryana','Himachal Pradesh']
}, {  
  letter: 'J',
names: ['Jammu & Kashmir','Jharkhand']
},  {  
  letter: 'K',
names: ['Karnataka','Kerala']
}, {  
  letter: 'M',
names: ['Madhya Pradesh','Maharashtra','Manipue','Meghalaya','Mizoram']
} ,  {  
  letter: 'N',
names: ['Nagaland']
},  {  
  letter: 'O',
names: ['Odisha']
},  {  
  letter: 'P',
names: ['Punjab']
},  {  
  letter: 'P',
names: ['Punjab']
},  {  
  letter: 'R',
names: ['Rajasthan']
},  {  
  letter: 'S',
names: ['Sikkim']
},  {  
  letter: 'T',
names: ['Tamil Nadu','Telangana','Tripura']
}, {  
  letter: 'U',
names: ['Uttar Pradesh', 'Uttarkhand']
},   {  
  letter: 'W',
names: ['West Bengal']
}



];
  
  stateGroupOptions: Observable<StateGroup[]>;

  constructor(private _formBuilder: FormBuilder) {}

  ngOnInit() {
    this.stateGroupOptions = this.stateForm.get('stateGroup')!.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filterGroup(value))
      );
  }

  private _filterGroup(value: string): StateGroup[] {
    if (value) {
      return this.stateGroups
        .map(group => ({letter: group.letter, names: _filter(group.names, value)}))
        .filter(group => group.names.length > 0);
    }

    return this.stateGroups;
  }
}

