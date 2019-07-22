import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shennav-owner',
  templateUrl: './shennav-owner.component.html',
  styleUrls: ['./shennav-owner.component.css']
})
export class ShennavOwnerComponent implements OnInit {

  constructor(private myRoute : Router) { }

  ngOnInit() {
  }


}
