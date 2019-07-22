import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookedStorageComponent } from './booked-storage/booked-storage.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
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
import { ListedStorageComponent } from './listed-storage/listed-storage.component';
import { RecommendationuserComponent } from './recommendationuser/recommendationuser.component';
import { BookingNewComponent } from './booking-new/booking-new.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { CardGuestComponent } from './card-guest/card-guest.component';
import { UserSearchResultComponent } from './user-search-result/user-search-result.component';
import { RecommendationguestComponent } from './recommendationguest/recommendationguest.component';





const routes: Routes = [

  //Fixed(Confirmed)
 
  { path: "", component: AppLandingComponent, pathMatch: 'full' },
  {path:'landing', component:AppLandingComponent},
  { path: 'recommendation', component: RecommendationguestComponent },
  { path: 'recommendation/:area/:sqft', component: SearchResultComponent },

  { path: 'recommendationUser/:area/:sqft', component: UserSearchResultComponent },
  { path: 'recommendationUser', component: RecommendationuserComponent },

  { path: 'details-book/:id', component: CardComponent },
  { path: 'details-list/:id', component: OnlyCardComponent },
  { path: 'details-guest/:id', component: CardGuestComponent },
  { path: 'bookbyid/:id/:pid', component: BookingNewComponent },
  { path: 'thanksBook', component: ThankYouComponent },
  { path: 'logout', component: LogoutDisplayComponent },
  { path: 'user-search', component: UserSearchComponent },
  { path: 'post-storage', component: JltComponent },
  { path: 'search', component: SearchResultComponent },
  { path: 'searchComp', component: PatchComponent },
  { path: 'booked-storage', component: BookedStorageComponent },
  { path: 'about', component: AboutusComponent },
  { path: 'details/:id', component: CardComponent },
  { path: 'listed-storage/:mail/:pwd', component: DashboardOwnerComponent },
  { path: 'listed-storage', component: ListedStorageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'logout', component: LogoutDisplayComponent },
  { path: 'card', component: CardComponent },
  { path: 'landingpage', component: AppLandingComponent },
  { path: 'owner-dashboard', component: DashboardOwnerComponent },
  { path: 'user-dashboard', component: DashboardUserComponent },
  { path: 'patch', component: PatchComponent },
  { path: 'jlt', component: JltComponent }




];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
