 import { Component } from '@angular/core';
 import { faCoffee } from '@fortawesome/fontawesome-svg-core;
 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'The Revature Library';
  faCoffee = faCoffee;
}