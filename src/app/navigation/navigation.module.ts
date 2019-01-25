import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import {HomeComponent} from '../home/home.component';

const routes: Routes = [
    {path: 'home', component: HomeComponent} 
];





@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule, FormsModule],
  exports: [RouterModule, ReactiveFormsModule, FormsModule],
})
export class AppRoutingModule { }