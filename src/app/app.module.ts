import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Route, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
//import { TextInputAutocompleteModule } from 'angular-text-input-autocomplete';
import { HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppHeaderComponent } from './app-header/app-header.component';
import { FooterComponent } from './footer/footer.component';
import {NavigationComponent} from './navigation/navigation.component'
//import { SidemenuComponent } from './sidemenu/sidemenu.component';
import { HomeComponent } from './home/home.component';
import {LibrarianComponent} from './librarian/librarian.component'
import { AuthenticationService} from './_services/authentication.service'


import { PatronComponent } from './patron/patron.component';
import { RegisterNewPatronComponent } from './register-new-patron/register-new-patron.component';
import { SearchBooksComponent } from './search-books/search-books.component';
import { ShowBookComponent } from './show-book/show-book.component';
import { LogoutComponent } from './logout/logout.component';
import { AccountinfoComponent } from './accountinfo/accountinfo.component';

// import { NavigationComponent } from './navigation/navigation.component';

const ROUTES: Route[] = [
 
  {path: 'login', component: LoginComponent},
  { path: 'librarian', component: LibrarianComponent},
  { path: 'patron', component: PatronComponent},  
  { path: 'home', component: HomeComponent},
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
    LibrarianComponent,
     NavigationComponent, 
     RegisterNewPatronComponent, 
     SearchBooksComponent, 
     ShowBookComponent, LogoutComponent, AccountinfoComponent
     
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    AppRoutingModule,
    //TextInputAutocompleteModule
    ],
  providers: [AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    // Add an icon to the library for convenient access in other components
    
  }
 }
