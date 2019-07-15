import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WarehouseServiceService } from '../warehouse-service.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
data:any;
partitionData:any;
  constructor(private route:ActivatedRoute, private warehouseService: WarehouseServiceService) { }

  ngOnInit() {


    const myVal = this.route.snapshot.paramMap.get('id');
    this.warehouseService.getWarehouseData(myVal).subscribe(data=>
      {
  
       this.partitionData=data;
       console.log("Partition data -- Details...");
       console.log(this.partitionData);
   
    });
  }

}
