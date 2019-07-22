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
import { MatFormFieldModule, MatCardModule,  MatButtonToggleModule,  MatSelectModule, MatOptionModule ,MatCheckboxModule} from '@angular/material';
import { MatInputModule } from '@angular/material';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDatepickerModule, MatNativeDateModule, MatRippleModule } from '@angular/material';
import { DatePipe } from '@angular/common';
import {MatDialogModule} from '@angular/material/dialog';


//Services

import { AuthService } from './auth.service';

// Components
import { AppComponent } from './app.component';
import { LogoutComponent } from './logout/logout.component';
import { FooterComponent } from './footer/footer.component';
import { DashboardUserComponent } from './dashboard-user/dashboard-user.component';
import { BookedStorageComponent } from './booked-storage/booked-storage.component';
import { DashboardOwnerComponent } from './dashboard-owner/dashboard-owner.component';
import { ListedStorageComponent } from './listed-storage/listed-storage.component';
import { DetailsComponent } from './details/details.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { PostStorageUnitComponent } from './post-storage-unit/post-storage-unit.component';
import { DetailsBookComponent } from './details-book/details-book.component';
import { TryAngularComponent } from './try-angular/try-angular.component'
import { RoughComponent } from './rough/rough.component';
import { ThankYouComponent } from './thank-you/thank-you.component';
import { LogoutDisplayComponent } from './logout-display/logout-display.component';
import { PatchComponent } from './patch/patch.component';
import { CardComponent } from './card/card.component';
import { JltComponent } from './jlt/jlt.component';
import { SearchResultComponent } from './search-result/search-result.component';
import { OnlyCardComponent } from './only-card/only-card.component';
import { AppLandingComponent } from './app-landing/app-landing.component';
import { ModalUserComponent } from './modal-user/modal-user.component';
import { UserSearchComponent } from './user-search/user-search.component';
import { UserSearchResultComponent } from './user-search-result/user-search-result.component';
import { RecommendationuserComponent } from './recommendationuser/recommendationuser.component';
import { RecommendationguestComponent } from './recommendationguest/recommendationguest.component';
import { BookingNewComponent } from './booking-new/booking-new.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { CardGuestComponent } from './card-guest/card-guest.component';
import { ShennavComponent} from './shennav/shennav.component';
import {ShennavUserComponent} from './shennav-user/shennav-user.component';
import {ShennavOwnerComponent} from './shennav-owner/shennav-owner.component';




@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    DashboardUserComponent,
    BookedStorageComponent,
    DashboardOwnerComponent,
    ListedStorageComponent,
    DetailsComponent,
    LoginComponent,
    RegisterComponent,
    SearchResultsComponent,
    PostStorageUnitComponent,
    LogoutComponent,
    RoughComponent,
    TryAngularComponent,
    DetailsBookComponent,
    ThankYouComponent,
    LogoutDisplayComponent,
    PatchComponent,
    CardComponent,
    JltComponent,
    SearchResultComponent,
    OnlyCardComponent,
    AppLandingComponent,
    ModalUserComponent,
    UserSearchComponent,
    UserSearchResultComponent,
    RecommendationuserComponent,
    RecommendationguestComponent,
    BookingNewComponent,
    AboutusComponent,
    CardGuestComponent,
    ShennavComponent,
    ShennavUserComponent,
    ShennavOwnerComponent
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
    MatAutocompleteModule,
    MatButtonToggleModule,
    MatCheckboxModule,
    MatDialogModule,
    MatSelectModule,
    MatOptionModule
    
 
    

  ],
  entryComponents: [ModalUserComponent],

  providers: [AuthService, LoginComponent, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
