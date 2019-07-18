import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit() {
  }


  search(area,sqft) {
    console.log(area,sqft);

    console.log("check1");


    this.router.navigateByUrl("/recommendationUser/"+area+"/"+sqft);
    
  }
}
