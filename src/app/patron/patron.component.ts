import { Component, OnInit, NgModule } from '@angular/core';


@Component({
  selector: 'app-patron',
  templateUrl: './patron.component.html',
  styleUrls: ['./patron.component.css']
})

export class PatronComponent implements OnInit {
  
 
  listitemone = 'View Fines';
  listitemtwo = 'Account Information';
  listitemthree = 'Request a Book';
  listitemfour = '';

  constructor() {  
  }

  ngOnInit() {
  }

};
