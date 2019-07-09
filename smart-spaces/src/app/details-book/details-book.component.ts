import { Component, OnInit } from '@angular/core';
import { WarehouseServiceService } from '../warehouse-service.service';
<<<<<<< HEAD
import { ActivatedRoute } from '@angular/router';
import { BookingsComponent } from '../bookings/bookings.component';
=======
import { ActivatedRoute, Router } from '@angular/router';
>>>>>>> 4db234bc2804f6a338fffe6e949a013dc6979cdb

@Component({
  selector: 'app-details-book',
  templateUrl: './details-book.component.html',
  styleUrls: ['./details-book.component.css']
})
export class DetailsBookComponent implements OnInit {
  partitionData ;
  constructor(private warehouseService: WarehouseServiceService,private router:Router, private route:ActivatedRoute) { }
  data:any;
  ngOnInit() {

    const myVal = this.route.snapshot.paramMap.get('id');
    this.warehouseService.getWarehouseData(myVal).subscribe(data=>
      {
  
       this.partitionData=data;
       console.log(this.partitionData);
   
    });

   

}




}

  Book(id) {

    console.log(id);
    this.router.navigateByUrl("/bookbyid/"+id);

  }


  

