import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

import { routing,CheckAuth } from './app.routing';

import { LoginComponent } from './login/login.component';
import { LoginService, MortgageService } from '../services/services.module';

import { MortgageComponent } from './mortgage/mortgage.component';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    MortgageComponent
  ],
  providers:[
  	LoginService,
	  MortgageService,
    CheckAuth
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }