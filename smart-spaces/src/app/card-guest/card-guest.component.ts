import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WarehouseServiceService } from '../warehouse-service.service';

@Component({
  selector: 'app-card-guest',
  templateUrl: './card-guest.component.html',
  styleUrls: ['./card-guest.component.css']
})
export class CardGuestComponent implements OnInit {
  data: any;
  partitionData: any;
  constructor(private route: ActivatedRoute, private warehouseService: WarehouseServiceService, private router: Router) { }

  ngOnInit() {


    const myVal = this.route.snapshot.paramMap.get('id');
    this.warehouseService.getWarehouseData(myVal).subscribe(data => {

      this.partitionData = data;
      console.log("Partition data -- Details...");
      console.log(this.partitionData);

    });
  }


  RegisterToBook(wid, pid) {
    sessionStorage.setItem('wid', wid);
    sessionStorage.setItem('pid', pid);
    // this.router.navigateByUrl("bookbyid/"+wid+"/"+pid);
    this.router.navigateByUrl("register");
  }

}
