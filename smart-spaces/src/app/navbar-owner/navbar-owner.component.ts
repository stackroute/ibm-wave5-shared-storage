import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-navbar-owner',
  templateUrl: './navbar-owner.component.html',
  styleUrls: ['./navbar-owner.component.css']
})
export class NavbarOwnerComponent implements OnInit {

  constructor(private auth: AuthService,
    private myRoute:Router,
    private log :LoginComponent) { }

  ngOnInit() {
  }

}
