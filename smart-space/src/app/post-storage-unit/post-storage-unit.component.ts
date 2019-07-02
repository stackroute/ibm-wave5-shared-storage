import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-post-storage-unit',
  templateUrl: './post-storage-unit.component.html',
  styleUrls: ['./post-storage-unit.component.css']
})
export class PostStorageUnitComponent implements OnInit {

  numbers:Array<any> = [];
  val = 1;
  constructor() {
    
    console.log(this.val+"  : Inside Constructor...");
    this.numbers = Array.from({length:this.val},(v,k)=>k+1);
    
    
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


  ngOnInit() {
  }

}
