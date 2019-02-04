import { Component, OnInit } from '@angular/core';
import { AuthService } from "../_services/auth.service";
import { Observable } from 'rxjs';

@Component({
  selector: 'app-show-book',
  styleUrls: ['./show-book.component.css'],
   template:`
   <table style="width:100%">
      <thead style="background-color:white">
          <th>Book Title</th>
          <th>Book Author</th>
          <th>Book ISBN</th>          
          <th>Book Image</th>
          <th>Keywords</th>
          <th>Book Description</th>
          <th *ngIf="(isLoggedIn | async)">Check Out Book</th>
      </thead>
      <tbody style="width:100%">
      <tr *ngFor="let books of currentBook" style="background-color:goldenrod; border: 3px solid black;height:50px">
          <td style="width:75px; padding: 5px"><b>{{books.title}}</b></td>
          <td style="width:150px; padding: 5px; text-align: center">{{books.author}}</td>
          <td style="padding:5px">{{books.ibsn}}</td>          
          <td style="padding: 5px"><a href="{{books.coverimageurl}}"><img src="{{books.coverimageurl}}" alt="Book Cover Image" height="200"></a></td>
          <td style="padding: 0 5px">{{books.keyword1.value}}, {{books.keyword2.value}}, {{books.keyword3.value}}</td>
          <td style="max-height:15px; padding: 5px; text-align:justify"  >{{books.description}}</td>
          <td class="button" style="padding: 0 5px"><button *ngIf="(isLoggedIn | async)">Checkout Book</button></td>
      </tr>
      </tbody>
      </table>
 `
})
export class ShowBookComponent implements OnInit {
  
 currentBook = JSON.parse(localStorage.getItem("currentBook"));
  isLoggedIn : Observable<boolean>;
  
  constructor(authService: AuthService) {
    this.isLoggedIn = authService.isLoggedIn();
   }

  ngOnInit() {
  }

  
}