import { Injectable } from '@angular/core';
import { Routes, RouterModule, Router, CanActivate } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { MortgageComponent } from './mortgage/mortgage.component';


@Injectable()
export class CheckAuth implements CanActivate {

    constructor(private router: Router) { }

    canActivate() {

        if (localStorage.getItem('userInfo')) return true;
        
        this.router.navigate(['/login']);
        return true;
    }
}

const appRoutes: Routes = [

    // route pages
    { path: "login", component: LoginComponent },
    { path: "mortgages", component: MortgageComponent, canActivate: [CheckAuth] },

    // Default
    { path: "**", redirectTo: "login" }

];


export const routing = RouterModule.forRoot(appRoutes,{ enableTracing: true });