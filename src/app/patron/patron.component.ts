import { Component, OnInit, NgModule, ElementRef, ViewChild } from '@angular/core';



@Component({
  selector: 'app-patron',
  templateUrl: './patron.component.html',
  styleUrls: ['./patron.component.css']
})
export class PatronComponent implements OnInit {
  
 
  listitemone = 'View Fines';
  listitemtwo = 'Account Information';
  listitemthree = 'Request a Book';
  

  constructor() {  
   
    
  };

  ngOnInit() {
    
  };
 viewFines() {
   console.log('clicked')
 };
 viewAccountInfo() {
  console.log('clicked')
};
requestBook() {
  console.log('clicked')
};
};
