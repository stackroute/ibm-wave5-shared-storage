import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchResultsComponent } from './search-results/search-results.component';
import { BookedStorageComponent } from './booked-storage/booked-storage.component';
import { BookingsComponent } from './bookings/bookings.component';
import { PostStorageUnitComponent } from './post-storage-unit/post-storage-unit.component';
import { LoginComponent } from './login/login.component';
import { DetailsComponent } from './details/details.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { LandingViewComponent } from './landing-view/landing-view.component';
import { RoughComponent } from './rough/rough.component';
import { DashboardOwnerComponent } from './dashboard-owner/dashboard-owner.component';
import { DashboardUserComponent } from './dashboard-user/dashboard-user.component';
import { PatchComponent } from './patch/patch.component';
import { CardComponent } from './card/card.component';
import { JltComponent } from './jlt/jlt.component';
import { LogoutDisplayComponent } from './logout-display/logout-display.component';
import { ThankYouComponent } from './thank-you/thank-you.component';
import { SearchResultComponent } from './search-result/search-result.component';
import { OnlyCardComponent } from './only-card/only-card.component';
import { AppLandingComponent } from './app-landing/app-landing.component';
import { UserSearchComponent } from './user-search/user-search.component';
import { UserSearchResultComponent } from './user-search-result/user-search-result.component';




const routes: Routes = [
  // { path: 'post-storage', component:PostStorageUnitComponent },
  { path: 'post-storage', component:JltComponent },
  { path: 'search', component: SearchResultComponent},
  { path: 'searchComp', component: PatchComponent },
  { path: 'booked-storage', component: BookedStorageComponent },
  { path: 'details/:id', component: CardComponent },
  { path: 'bookings', component: BookingsComponent },
  { path: 'listed-storage/:mail/:pwd', component: DashboardOwnerComponent },
  { path: 'listed-storage', component: DashboardOwnerComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'logout', component: LogoutDisplayComponent },
  { path: "", component:AppLandingComponent, pathMatch: 'full' },
  { path: 'card', component:CardComponent},
  { path: 'landing', component: LandingViewComponent },
  { path: 'landingpage', component: AppLandingComponent },
  { path: 'recommendation', component: DashboardUserComponent },
  { path: 'owner-dashboard', component: DashboardOwnerComponent },
  { path: 'user-dashboard', component: DashboardUserComponent },
  { path: 'details-book/:id', component: CardComponent },
  { path: 'book', component: BookingsComponent },
  { path: 'bookbyid/:id/:pid', component: BookingsComponent },
  { path: 'rough', component: RoughComponent },
  { path: 'patch', component: PatchComponent },
  { path: 'jlt', component: JltComponent },
  { path: 'ldisplay', component: LogoutDisplayComponent },
  { path: 'tu', component: ThankYouComponent },
  {path:'sr',component:SearchResultComponent},
  {path:'details-list/:id',component:OnlyCardComponent},
  {path:'user-search',component: UserSearchComponent},
  {path:'user-serach-result',component:UserSearchResultComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
