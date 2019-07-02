import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SearchResultsComponent } from './search-results/search-results.component';
import { BookedStorageComponent } from './booked-storage/booked-storage.component';

import { BookingsComponent } from './bookings/bookings.component';
import { PostStorageUnitComponent } from './post-storage-unit/post-storage-unit.component';
import { PartitionComponent } from './partition/partition.component';



import { LoginComponent } from './login/login.component';
import { ListedStorageComponent } from './listed-storage/listed-storage.component';
import { DetailsComponent } from './details/details.component';
import { LogoutComponent } from './logout/logout.component';



const routes: Routes = [

  {path:'post-storage',component:PostStorageUnitComponent},
  {path:'search', component:SearchResultsComponent},
  {path:'booked-storage',component:BookedStorageComponent} ,
 {path:'details', component:DetailsComponent},
 {path:'bookings', component:BookingsComponent},
 {path:'partition', component:PartitionComponent},
 {path:'listed-storage',component:ListedStorageComponent},
 {path:'login',component:LoginComponent},
 {path:'logout', component:LogoutComponent}
 


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
