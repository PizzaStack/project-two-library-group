import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patron',
  templateUrl: './patron.component.html',
  styleUrls: ['./patron.component.css']
})
export class PatronComponent implements OnInit {
  
  sidebar: HTMLElement = document.getElementById("item3");
  

  constructor() { 
    this.sidebar.innerHTML = '';
  }

  ngOnInit() {
  }

};
