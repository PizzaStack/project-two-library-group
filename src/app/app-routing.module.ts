import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {PatronComponent} from './patron/patron.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  
  {path: 'patron', component: PatronComponent},
  {path: 'login', component: LoginComponent},
  { path: '', component: HomeComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
