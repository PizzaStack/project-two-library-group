import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { BehaviorSubject } from 'rxjs';
import {book} from '../books'
import {AuthService} from './auth.service'


const
httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
   };

@Injectable()
export class AuthenticationService {
    currentBook: book;
    private loggedIn = new BehaviorSubject<boolean>(false);

    get isLoggedIn() {
        return this.loggedIn.asObservable(); // {2}
      }

    constructor(private http: HttpClient, private auth : AuthService) { }

   
   url: string = 'http://localhost:8080/LoginUser/';
    bookURL: string = 'http://localhost:8080/Book/';
    authorURL: string = 'http://localhost:8080/Book/author';

    login(userName: string, password: string) {
        if (userName !== '' && password !== '' ) { // {3}
      this.auth.login();
         }
      
        return this.http.get<any>(this.url.concat( userName + "/" + password))
            .pipe(map(user => {
                // login successful if there's a jwt token in the response
                if (user) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    
                     localStorage.setItem("currentuser", JSON.stringify(user));
                }
                console.log(user);
                return user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        localStorage.removeItem("currentBook");
        localStorage.removeItem("currentBookAuthor");
    }

    search(bookTitle: string){
        return this.http.get<any>(this.bookURL.concat(bookTitle),httpOptions)
        .pipe(map(book => {
            if(book){
              localStorage.setItem("currentBook", JSON.stringify(book));
            }
            return book;
        }));
    }
    author(bookAuthor: string){
        return this.http.get<any>(this. authorURL.concat(bookAuthor),httpOptions)
        .pipe(map(book => {
            if(book){
              localStorage.setItem("currentBookAuthor", JSON.stringify(book));
            }
            return book;
        }));
    }
}