import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Route, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppHeaderComponent } from './app-header/app-header.component';
import { FooterComponent } from './footer/footer.component';
import {NavigationComponent} from './navigation/navigation.component'
//import { SidemenuComponent } from './sidemenu/sidemenu.component';
import { HomeComponent } from './home/home.component';


 import { PatronComponent } from './patron/patron.component';
// import { LibrarianComponent } from './librarian/librarian.component';
// import { NavigationComponent } from './navigation/navigation.component';

const ROUTES: Route[] = [
 
  {path: 'login', component: LoginComponent},
  { path: 'patron', component: PatronComponent},
  { path: '', component: HomeComponent, pathMatch: 'full' }
 
]

@NgModule({
  declarations: [
    AppComponent,   
    AppHeaderComponent,
    HomeComponent,
    LoginComponent,
    PatronComponent,
    
    FooterComponent,     
    // LibrarianComponent,
     NavigationComponent,
   // SidemenuComponent,
   
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    AppRoutingModule,
    
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    // Add an icon to the library for convenient access in other components
    
  }
 }
