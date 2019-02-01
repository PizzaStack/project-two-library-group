import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { User} from '../users';

import {AuthenticationService } from '../_services/authentication.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Component(
    {templateUrl: 'login.component.html',
    styleUrls: ['./login.component.css'],})
export class LoginComponent implements OnInit {
    currentUser: User;
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    usersInfo: any;
    userName: string = "";
    username: string;
    password: string;
    userID: number;
    isLibrarian: boolean;

    private loggedIn = new BehaviorSubject<boolean>(false);

    get isLoggedIn() {
        return this.loggedIn.asObservable(); // {2}
      }

    isLoggedIn$: Observable<boolean>; 
    
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService){}

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

        // reset login status
        this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

        //get current user info
        this.currentUser = this.getCurrentUserInfo();

        this.isLoggedIn$ = this.isLoggedIn;
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    getCurrentUserInfo(): User{
        var currentUser = JSON.parse(localStorage.getItem("currentuser"));
        return currentUser;
       }
    
    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.authenticationService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                     this.usersInfo = (data);
                    
                    if(this.usersInfo.librarian){       
                        this.loggedIn.next(true);
                    this.router.navigate(['/librarian']);
                    }else                
                    this.loggedIn.next(true);
                    this.router.navigate(['patron']);
                },
                error => {
                    //this.alertService.error(error);
                    this.loading = false;
                });
            }
            onLogout(){
                this.authenticationService.logout(); 
              }
    }




