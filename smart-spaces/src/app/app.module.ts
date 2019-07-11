//Modules
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ShowHidePasswordModule } from 'ngx-show-hide-password';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { MatStepperModule } from '@angular/material/stepper';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule, MatCardModule } from '@angular/material';
import { MatInputModule } from '@angular/material';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDatepickerModule, MatNativeDateModule, MatRippleModule } from '@angular/material';

//Services

import { AuthService } from './auth.service';

// Components
import { AppComponent } from './app.component';
import { LogoutComponent } from './logout/logout.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchComponent } from './search/search.component';
import { FooterComponent } from './footer/footer.component';
import { DashboardUserComponent } from './dashboard-user/dashboard-user.component';
import { BookedStorageComponent } from './booked-storage/booked-storage.component';
import { DashboardOwnerComponent } from './dashboard-owner/dashboard-owner.component';
import { ListedStorageComponent } from './listed-storage/listed-storage.component';
import { DetailsComponent } from './details/details.component';
import { BookingsComponent } from './bookings/bookings.component';
import { LoginComponent } from './login/login.component';
import { LandingViewComponent } from './landing-view/landing-view.component';
import { RegisterComponent } from './register/register.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { PostStorageUnitComponent } from './post-storage-unit/post-storage-unit.component';
import { AppPageComponent } from './app-page/app-page.component';
import { DetailsBookComponent } from './details-book/details-book.component';
import { AutocompleteComponent } from './autocomplete/autocomplete.component';
import { TryAngularComponent } from './try-angular/try-angular.component'
import { RoughComponent } from './rough/rough.component';
import { NavbarUserComponent } from './navbar-user/navbar-user.component';
import { NavbarOwnerComponent } from './navbar-owner/navbar-owner.component';
import { MynavComponent } from './mynav/mynav.component';
import { PatchComponent } from './patch/patch.component';
import { PatchnavComponent } from './patchnav/patchnav.component';












@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SearchComponent,
    FooterComponent,
    DashboardUserComponent,
    BookedStorageComponent,
    DashboardOwnerComponent,
    ListedStorageComponent,
    DetailsComponent,
    BookingsComponent,
    LoginComponent,
    RegisterComponent,
    SearchResultsComponent,
    PostStorageUnitComponent,
    LogoutComponent,
    LandingViewComponent,
    RoughComponent,
    NavbarUserComponent,
    NavbarOwnerComponent,
    MynavComponent,


    
    TryAngularComponent,
    AppPageComponent,
    DetailsBookComponent,
    AutocompleteComponent,
    PatchComponent,
    PatchnavComponent

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
    MatCardModule,
    ReactiveFormsModule,
    MatAutocompleteModule

  ],

  providers: [AuthService, LoginComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
