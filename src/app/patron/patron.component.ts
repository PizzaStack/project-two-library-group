import { Component, OnInit, NgModule, ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from "../users";
import { Router } from '@angular/router'
import { AccountinfoComponent } from "../accountinfo/accountinfo.component";
@Component({
  selector: 'app-patron',
  templateUrl: './patron.component.html',
  styleUrls: ['./patron.component.css']
})
export class PatronComponent implements OnInit {
  username: string;
  booksArray: any;
  userInfoFromStorage: User;
  listitemtwo = 'View Account Information';
  listitemthree = 'Request a Book';
  listitemfour = 'Dashboard';
  userinfoURL: string= 'http://3.16.23.149:8090/';
  booksByPatronUrl: string = 'http://3.16.23.149:8090/Book/Patron/';
  boolAccountInfo : boolean;

  constructor(private http: HttpClient, private router: Router) {};

  ngOnInit() {
    this.boolAccountInfo = true;
    this.userInfoFromStorage = JSON.parse(localStorage.getItem("currentuser"));
    this.username = this.userInfoFromStorage.username;
    this.getBooksByPatron();
  };
  
  @ViewChild('patronbody') bodyDiv: ElementRef;
 
 viewAccountInfo() {
   this.boolAccountInfo = !this.boolAccountInfo;
};
requestBook() {
  this.bodyDiv.nativeElement.innerHTML = `<h3>Book Request Form</h3><form>
  <input type="text" placeholder="Book title" #booktitle><br><br>
  <input type="text" placeholder="ISBN" #isbn><br><br>
  <button type="button" (click)="submitRequest()">Submit</button>
</form>`;
};
@ViewChild('name') nameSpan: ElementRef;
@ViewChild('number') numberSpan: ElementRef;
editInfo() {
  this.nameSpan.nativeElement.innerHTML = `<input type= "text" placeholder="Please Enter Your Name">`;
  this.numberSpan.nativeElement.innerHTML = `<input type= "text" placeholder="Please Enter Your Number">`;
  console.log("clicked");
}

dashboard(){
  this.router.navigate(['/patron']);
};

getBooksByPatron() {
  this.http.get(this.booksByPatronUrl.concat(this.username).concat('/'))
    .subscribe((data) => {
      this.booksArray = data;
      console.log(this.booksArray);
    })
}
};
