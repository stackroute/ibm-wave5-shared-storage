import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-partitions',
  templateUrl: './partitions.component.html',
  styleUrls: ['./partitions.component.css']
})
export class PartitionComponent implements OnInit {

  numbers:Array<any> = [];
  constructor() {
    this.numbers = Array.from({length:10},(v,k)=>k+1);
   }

  ngOnInit() {
  }

}


