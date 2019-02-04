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
      'Access-Control-Allow-Origin': '*', 
'Access-Control-Allow-Methods': 'HEAD, GET, POST, PUT, PATCH, DELETE',
'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
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

   
   url: string = 'http://3.16.23.149:8090/LoginUser/';
    bookURL: string = 'http://3.16.23.149:8090/Book/parameter/';
    authorURL: string = 'http://3.16.23.149:8090/Book/author';
    userinfoURL: string= 'http://3.16.23.149:8090/LoginUser/Info'

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
                     this.setInfo();
                }
                console.log(user);
                return user;
            }));
    }

    setInfo() {
        
            return this.http.get<any>(this.userinfoURL)
            .pipe(map(info => {
                if(info) {
                    localStorage.setItem("userinfo", JSON.stringify(info));
                }
                console.log(info);
                return info;
            }));
        
        
    };

    logout() {
        
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        localStorage.removeItem("currentBook");
        localStorage.removeItem("currentBookAuthor");
        return this.http.get<any>('http://3.16.23.149:8090/LoginUser/Logout');
        }

    search(bookParameter: string){
        return this.http.get<any>(this.bookURL.concat(bookParameter),httpOptions)
        .pipe(map(book => {
            
            if(book){
                
              localStorage.setItem("currentBook", JSON.stringify(book));
            }
            return book;
        }));
    }
}