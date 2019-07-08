import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchComponent } from './search/search.component';
import { FooterComponent } from './footer/footer.component';
import { DashboardUserComponent } from './dashboard-user/dashboard-user.component';
import { RecommendationsComponent } from './recommendations/recommendations.component';
import { BookedStorageComponent } from './booked-storage/booked-storage.component';
import { DashboardOwnerComponent } from './dashboard-owner/dashboard-owner.component';
import { ListedStorageComponent } from './listed-storage/listed-storage.component';
import { DetailsComponent } from './details/details.component';
import { BookingsComponent } from './bookings/bookings.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { PostStorageUnitComponent } from './post-storage-unit/post-storage-unit.component';
import { PartitionComponent } from './partition/partition.component';
import { AuthService } from './auth.service';
import { HttpClientModule } from '@angular/common/http';
import { LogoutComponent } from './logout/logout.component';
import { LandingViewComponent } from './landing-view/landing-view.component';
import { ShowHidePasswordModule } from 'ngx-show-hide-password';


import { RoughComponent } from './rough/rough.component';
import { NavbarUserComponent } from './navbar-user/navbar-user.component';
import { NavbarOwnerComponent } from './navbar-owner/navbar-owner.component';
import { MatStepperModule } from '@angular/material/stepper';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MynavComponent } from './mynav/mynav.component';
import { DetailsGeneralComponent } from './details-general/details-general.component';
import { TryAngularComponent } from './try-angular/try-angular.component'
import { MatFormFieldModule, MatCardModule } from '@angular/material';
import { MatInputModule } from '@angular/material';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDatepickerModule, MatNativeDateModule,MatRippleModule} from '@angular/material';
import { AppPageComponent } from './app-page/app-page.component';
import { DetailsBoolComponent } from './details-bool/details-bool.component';
import { DetailsBookComponent } from './details-book/details-book.component';






@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SearchComponent,
    FooterComponent,
    DashboardUserComponent,
    RecommendationsComponent,
    BookedStorageComponent,
    DashboardOwnerComponent,
    ListedStorageComponent,
    DetailsComponent,
    BookingsComponent,
    LoginComponent,
    RegisterComponent,
    SearchResultsComponent,
    PostStorageUnitComponent,
    PartitionComponent,
    LogoutComponent,
    LandingViewComponent,
    RoughComponent,
    NavbarUserComponent,
    NavbarOwnerComponent,
    MynavComponent,
    DetailsGeneralComponent,
    TryAngularComponent,
     AppPageComponent,
     DetailsBoolComponent,
     DetailsBookComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ShowHidePasswordModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    MatStepperModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSnackBarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRippleModule,
    MatCardModule

  ],

  providers: [AuthService, LoginComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
