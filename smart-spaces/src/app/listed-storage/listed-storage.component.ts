import { Component, OnInit } from '@angular/core';
import { UserProfileService } from '../user-profile.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listed-storage',
  templateUrl: './listed-storage.component.html',
  styleUrls: ['./listed-storage.component.css']
})
export class ListedStorageComponent implements OnInit {
  mail:any;
  ArrayOfWarehouseData : any = [];
  constructor(private upService:UserProfileService, private router:Router) { }
  data:any;
  ngOnInit() {

    this.mail = (JSON.parse(sessionStorage.getItem('details')).iss);

    this.upService.getListedData(this.mail).subscribe(data=>
      {
  
       this.ArrayOfWarehouseData=data;
       console.log(this.ArrayOfWarehouseData);
   
    });
  

  }
  details(data){

    console.log(data);
    this.router.navigateByUrl("/details-list/"+data);
        
  }
}
