import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { library } from '@fortawesome/fontawesome-svg-core';
import { faBell, faCircle } from '@fortawesome/free-regular-svg-icons';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppHeaderComponent } from './app-header/app-header.component';
import { Route, RouterModule } from '@angular/router';


import { FooterComponent } from './footer/footer.component';
import {NavigationComponent} from './navigation/navigation.component';
import { SidemenuComponent } from './sidemenu/sidemenu.component';
import { HomeComponent } from './home/home.component';


 //import { PatronComponent } from './patron/patron.component';
// import { LibrarianComponent } from './librarian/librarian.component';
// import { NavigationComponent } from './navigation/navigation.component';

const ROUTES: Route[] = [
  { path: '', redirectTo: '/', pathMatch: 'full' }
 // { path: 'patron', component: PatronComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AppHeaderComponent,
    FooterComponent,
    // PatronComponent,
    // LibrarianComponent,
     NavigationComponent,
    SidemenuComponent,
    HomeComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
    
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    // Add an icon to the library for convenient access in other components
    library.add(faBell, faCircle);
  }
 }
