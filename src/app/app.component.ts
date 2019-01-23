 import { Component } from '@angular/core';
 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'The Revature Library';

  columnDefs = [
    {headerName: 'Make', field: 'make'},
    {headerName: 'Model', field: 'model'},
    {headerName: 'Price', field: 'price'}
];

rowData = [
   
];
ngOnInit() {
  fetch('https://api.myjson.com/bins/15psn9')
    .then(result => result.json())
    .then(rowData => this.rowData = rowData);
}
}