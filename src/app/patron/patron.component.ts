import { Component, OnInit, NgModule, ElementRef, ViewChild } from '@angular/core';
import { userInfo } from '../userInfo';

@Component({
  selector: 'app-patron',
  templateUrl: './patron.component.html',
  styleUrls: ['./patron.component.css']
})
export class PatronComponent implements OnInit {
  
  firstname: string; 
  lastname: string; 
  address: string; 
  phonenumber: number; 
  emailaddress: string;
  info: userInfo;
  listitemtwo = 'Account Information';
  listitemthree = 'Request a Book';
  listitemfour = 'Dashboard';
  

  constructor() {  
   
    
  };

  ngOnInit() {
    this.info = JSON.parse(localStorage.getItem("userInfo"));
    this.firstname = this.info.firstName;
    this.lastname = this.info.lastName;
    this.address = this.info.address;
    this.emailaddress = this.info.emailAddress;
    this.phonenumber = this.info.phoneNumber;
  };
  
  @ViewChild('patronbody') bodyDiv: ElementRef;
 
 viewAccountInfo() {
  this.bodyDiv.nativeElement.innerHTML = `<h3>Account Information</h3><label>Name:</label><span #name>${this.firstname}</span><br><br>
  <label>Phone Number:</label><span #number>${this.phonenumber}</span><br><br>
  <label>Email Address:</label><span #email>${this.emailaddress}</span><br><br>
  <label>Address:</label><span #address>${this.address}</span>`;
  
};
requestBook() {
  this.bodyDiv.nativeElement.innerHTML = `<h3>Book Request Form</h3><form>
  <input type="text" placeholder="Book title" #booktitle><br><br>
  <input type="text" placeholder="ISBN" #isbn><br><br>
  <button type="button" (click)="submitRequest()"=>Submit</button>
</form>`;
 
};
dashboard(){
  this.bodyDiv.nativeElement.innerHTML = `<label>Checked out books:</label><br>
  <table id="checkedouttable">
  <th>Cover Image</th>
  <th>Title</th>
  <th>Author</th>
  <th>Due Date</th>
</table>

<br><br><label>Book History:</label><br>
<table id="bookhistorytable">
  <th>Cover Image</th>
  <th>Title</th>
  <th>Author</th>
  <th>Check-out Date</th>
</table><div #fine><br><span #balance>Balance Due: $0.01</span></div>`
};
};
