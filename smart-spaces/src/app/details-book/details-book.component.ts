import { Component, OnInit } from '@angular/core';
import { WarehouseServiceService } from '../warehouse-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-book',
  templateUrl: './details-book.component.html',
  styleUrls: ['./details-book.component.css']
})
export class DetailsBookComponent implements OnInit {
  partitionData ;
  constructor(private warehouseService: WarehouseServiceService, private route:ActivatedRoute) { }
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
