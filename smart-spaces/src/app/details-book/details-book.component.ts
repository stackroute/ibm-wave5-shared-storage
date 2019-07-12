import { Component, OnInit } from '@angular/core';
import { WarehouseServiceService } from '../warehouse-service.service';
import { ActivatedRoute, Router } from '@angular/router';

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
       console.log("Partition data -- Details...");
       console.log(this.partitionData);
   
    });

   

}





    // this.router.navigateByUrl("/bookbyid/"+id+"/"+pid);
  }



  

