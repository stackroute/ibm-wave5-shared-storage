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
import { RegisterComponent } from './register/register.component';
import { LandingViewComponent } from './landing-view/landing-view.component';
import { SearchComponent } from './search/search.component';
import { RecommendationsComponent } from './recommendations/recommendations.component';
import { RoughComponent } from './rough/rough.component';



const routes: Routes = [
  { path: 'post-storage', component: PostStorageUnitComponent },
  { path: 'search', component: SearchResultsComponent },
  { path: 'searchComp', component: SearchComponent },
  { path: 'booked-storage', component: BookedStorageComponent },
  { path: 'details/:id', component: DetailsComponent },
  { path: 'bookings', component: BookingsComponent },
  { path: 'partition', component: PartitionComponent },
  { path: 'listed-storage', component: ListedStorageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'logout', component: LogoutComponent },
  { path: "", component: LandingViewComponent, pathMatch: 'full' },
  { path: 'landing', component: LandingViewComponent },
  { path: 'recommendation', component: RecommendationsComponent },

 { path: 'rough', component: RoughComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
