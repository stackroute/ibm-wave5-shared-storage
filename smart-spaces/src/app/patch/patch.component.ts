import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patch',
  templateUrl: './patch.component.html',
  styleUrls: ['./patch.component.css']
})
export class PatchComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit() {
  }

  search(area, sqft){
    console.log(area,sqft);
    
    console.log("Check guest search");
    this.router.navigateByUrl("/recommendation/"+area+"/"+sqft);

  }

}
