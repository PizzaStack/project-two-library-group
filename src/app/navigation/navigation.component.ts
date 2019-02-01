import { Component, OnInit } from '@angular/core';
import {AuthenticationService } from '../_services/authentication.service';
import { BehaviorSubject, Observable } from 'rxjs';


@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],

  
})
export class NavigationComponent implements OnInit {

  private loggedIn = new BehaviorSubject<boolean>(false);

  get isLoggedIn() {
      return this.loggedIn.asObservable(); // {2}
    }

  isLoggedIn$: Observable<boolean>; 

  
  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.isLoggedIn$ = this.authenticationService.isLoggedIn;
  }

}