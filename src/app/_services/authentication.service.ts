import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';


const
httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
   };

@Injectable()
export class AuthenticationService {
    constructor(private http: HttpClient) { }

   
   url: string = 'http://localhost:8080/LoginUser/';
    bookURL: string = 'http://localhost:8080/Book/';

    login(userName: string, password: string) {
      
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
}