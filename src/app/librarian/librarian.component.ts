import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AccountinfoComponent } from "../accountinfo/accountinfo.component";

@Component({
  selector: 'app-librarian',
  templateUrl: './librarian.component.html',
  styleUrls: ['./librarian.component.css']
})
export class LibrarianComponent implements OnInit {
  patronUrl: string = 'http://localhost:8080/Patrons';
  checkedOutBooksUrl: string = 'http://localhost:8080/Book/GetBooksCheckedOut';
  booksByPatronUrl: string = 'http://localhost:8080/Book/Patron/';
  returnBookUrl: string = 'http://localhost:8080/Book/Return/';
  createPatronUrl: string = 'http://localhost:8080/Patrons/CreateNewPatron/';
  patronArray: any;
  booksArray: any;
  boolGetBooksWithId: boolean;
  boolAccountInfo : boolean;
  @ViewChild('patronUsername') patronUsername: ElementRef;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.boolAccountInfo = true;
    this.getAllPatron();
    this.getCheckedOutBooks();
  }

  viewAccountInfo() { 
    this.boolAccountInfo = !this.boolAccountInfo;
  }
  createPatronAccount() { }

  createPatron() {
    //{username}/{password}/{firstName}/{lastName}/{phoneNumber}/{address}/{emailAddress};
  }

  getBooksByPatron(username: string) {
    this.boolGetBooksWithId = false;
    this.http.get(this.booksByPatronUrl + username)
      .subscribe((data) => {
        this.booksArray = data;
        console.log(this.booksArray);
      })
  }

  getCheckedOutBooks() {
    this.patronUsername.nativeElement.value = "";
    this.boolGetBooksWithId = true;
    this.http.get(this.checkedOutBooksUrl)
      .subscribe((data) => {
        this.booksArray = data;
        console.log(this.booksArray);
      })
  }

  getAllPatron() {
    this.http.get(this.patronUrl)
      .subscribe((data) => {
        this.patronArray = data;
        console.log(this.patronArray);
      })
  }

  returnBook(button : ElementRef) {
    console.log(button.nativeElement);
    console.log(button.nativeElement.parentNode);
    let row = button.nativeElement.parentNode.parentNode;
    let rowIndex = row.rowIndex;
    let table = row.parentNode;
    this.http.get(this.returnBookUrl + row.cells[1].innerHtml);
    table.deleteRow(rowIndex);
  }
}
