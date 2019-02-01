import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {PatronComponent} from './patron/patron.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import{LibrarianComponent} from './librarian/librarian.component';
import {SearchBooksComponent} from './search-books/search-books.component'
import { ShowBookComponent } from './show-book/show-book.component';

const routes: Routes = [
  
  {path: 'librarian', component: LibrarianComponent},
  {path: 'patron', component: PatronComponent},
  {path: 'login', component: LoginComponent},
  {path: 'search', component: SearchBooksComponent},
  {path: 'showBook', component: ShowBookComponent},
  { path: '', component: HomeComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
