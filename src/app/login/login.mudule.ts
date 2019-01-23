import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import {LibrarianComponent} from '../librarian/librarian.component';
import{PatronComponent} from '../patron/patron.component';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  {path: 'librarian', component: LibrarianComponent},
  {path: 'patron', component: PatronComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule, FormsModule],
  exports: [RouterModule, ReactiveFormsModule, FormsModule],
})
export class AppRoutingModule { }