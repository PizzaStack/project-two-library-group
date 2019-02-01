import { Component, OnInit } from '@angular/core';
import { getLocalRefs } from '@angular/core/src/render3/discovery_utils';
import {book} from '../books'

@Component({
  selector: 'app-show-book',
  templateUrl: './show-book.component.html',
  styleUrls: ['./show-book.component.css']
})
export class ShowBookComponent implements OnInit {
  current:book;
  title : string;  
  author: number;
   isbn: number;
   keyword1: number;
   keyword2: number;
   keyword3: number;
   coverimageurl: string;
   description: string;

  
  constructor() { }

  ngOnInit() {
    this.current = this.getLocalBook();
    this.title = this.current.title;
    console.log(this.current.title)
  }

  getLocalBook() : book{ 
  var currentBook = JSON.parse(localStorage.getItem("currentBook"));
  console.log(currentBook);
  return currentBook;
  }
}
