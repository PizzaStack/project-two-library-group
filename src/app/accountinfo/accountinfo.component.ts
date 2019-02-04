import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from "../users";

@Component({
  selector: 'app-accountinfo',
  templateUrl: './accountinfo.component.html',
  styleUrls: ['./accountinfo.component.css']
})
export class AccountinfoComponent implements OnInit {

  patronUpdateUrl: string = 'http://3.16.23.149:8090/Patrons/UpdatePatronInfo/';
  librarianUpdateUrl: string = 'http://3.16.23.149:8090/LoginUser/UpdateLibrarianInfo/';
  userinfoURL: string= 'http://3.16.23.149:8090/';
  userInfoFromStorage: User;

  username : string;
  firstname : string;
  lastname : string;
  phonenumber : string;
  emailaddress : string;
  address : string;
  boolIsPatron : boolean;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.userInfoFromStorage = JSON.parse(localStorage.getItem("currentuser"));
    this.username = this.userInfoFromStorage.username;
    this.boolIsPatron = !this.userInfoFromStorage.isLibrarian;
    this.getUserInfo();
  }

  getUserInfo(){
    this.http.get(this.userinfoURL.concat(this.username).concat('/'))
    .subscribe((data) => {
      let user : any = data;
      console.log(user);
      this.firstname = user.firstName;
      this.lastname = user.lastName;
      if (this.boolIsPatron) {
        this.phonenumber = user.phoneNumber;
        this.emailaddress = user.emailAddress;
        this.address = user.address;
      }
    })
  }

  editInfo() {
    
  }
}
