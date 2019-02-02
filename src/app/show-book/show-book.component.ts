import { Component, OnInit } from '@angular/core';
import { getLocalRefs } from '@angular/core/src/render3/discovery_utils';
import {book} from '../books'
import{keyWords} from '../keywords'
import { AuthService } from "../_services/auth.service";
import { Observable } from 'rxjs';

@Component({
  selector: 'app-show-book',
  templateUrl: './show-book.component.html',
  styleUrls: ['./show-book.component.css'],
  template:`
  <div class="book">
  <h2>Book Title: {{title}}</h2>
<input type="hidden"  value="Book Title: {{title}}" >
<h3><img src="{{coverimageurl}}" height="500"></h3>
<h3>Author: {{author}}</h3>
<h3>ISBN: {{isbn}}</h3>
<h3>Description: {{description}}</h3>
<h3>Keywords {{keyword1}}, {{keyword2}}, {{keyword3}}</h3>
<button *ngIf="(isLoggedIn | async)">Checkout Book</button>
</div>`
})
export class ShowBookComponent implements OnInit {
  
  current:book;
  currentKeywords:keyWords;
  title : string;  
  author: string;
   isbn: number;
   keyword1: number;
   keyword2: number;
   keyword3: number;
   coverimageurl: string;
   description: string;
  ISBN : any;

  isLoggedIn : Observable<boolean>;
  
  constructor(private authService: AuthService) {
    this.isLoggedIn = authService.isLoggedIn();
   }

  ngOnInit() {
    
   this.getCurrentBook();
   
  }

  getCurrentBook(){
    this.current = this.getLocalBook();
    this.title = this.current.title;
    this.author = this.current.author;
    this.isbn = this.current.ibsn;
    this.coverimageurl = this.current.coverimageurl;
    this.description = this.current.description;
    
    let keywords1 = JSON.stringify(this.current.keyword1);
    let keywords2 = JSON.stringify(this.current.keyword2);
    let keywords3 = JSON.stringify(this.current.keyword3);
    let keyword_1 = JSON.parse(keywords1);
    let keyword_2 = JSON.parse(keywords2);
    let keyword_3 = JSON.parse(keywords3);
    this.keyword1 = keyword_1.value;
    this.keyword2 = keyword_2.value;
    this.keyword3 = keyword_3.value;
  }

  getLocalBook() : book{ 
  
  var currentBook = JSON.parse(localStorage.getItem("currentBook"));
  var currentKeywords = JSON.parse(localStorage.getItem("currentBook"));
  // if(currentBook == null)
  // alert("Book is not currently available in the library");
  // else{
  console.log(currentBook);
  return currentBook;
  }
  //}
}
