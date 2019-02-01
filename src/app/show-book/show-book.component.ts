import { Component, OnInit } from '@angular/core';
import { getLocalRefs } from '@angular/core/src/render3/discovery_utils';
import {book} from '../books'
import{keyWords} from '../keywords'

@Component({
  selector: 'app-show-book',
  templateUrl: './show-book.component.html',
  styleUrls: ['./show-book.component.css']
})
export class ShowBookComponent implements OnInit {
  
  current:book;
  currentKeywords:keyWords;
  title : string;  
  author: string;
   isbn: number;
   keyword1: string;
   keyword2: string;
   keyword3: string;
   coverimageurl: string;
   description: string;

  
  constructor() {
    
   }

  ngOnInit() {
    
   this.getCurrentBook();
   
  }

  getCurrentBook(){
    this.current = this.getLocalBook();
    this.title = this.current.title;
    this.author = this.current.author;
    this.isbn = this.current.isbn;
    this.coverimageurl = this.current.coverimageurl;
    this.description = this.current.description;
    this.keyword1 = this.current.keyword1.toString();
    this.keyword2 = this.current.keyword2.toString();
    this.keyword1 = this.current.keyword3.toString();
    console.log(this.current.keyword3.toString());
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
