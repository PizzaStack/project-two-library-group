import { Component, OnInit } from '@angular/core';
import {AuthenticationService } from '../_services/authentication.service';
import { BehaviorSubject, Observable } from 'rxjs';
import { AuthService } from "../_services/auth.service";



@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],

  
})
export class NavigationComponent implements OnInit {

  isLoggedIn : Observable<boolean>;

  

   constructor(private authenticationService: AuthenticationService, public authService : AuthService) { 
    this.isLoggedIn = authService.isLoggedIn();
   }

  ngOnInit() {
    
  }

}