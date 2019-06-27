import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  helper: any;

  constructor(private auth: AuthService,
 private myRoute:Router,
 private log :LoginComponent) { }
   
    

  ngOnInit( ) {

    
  }

  
}
