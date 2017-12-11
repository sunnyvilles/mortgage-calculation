import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from '../../services/services.module';

@Component({
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit{

    user: any = {};
    error = '';

    constructor(private router: Router, private loginService: LoginService) { }

    ngOnInit(){
        this.loginService.removeUser();
    }

    onLogin() {
            
            //this.router.navigate(['/mortgages']);

            this.loginService.authenticate(this.user.username, this.user.password)
            .subscribe(result => {

                if (result === true) {

                    this.router.navigate(['/mortgages']);

                } else {

                    this.error = 'Username or password is incorrect';

                }
            });
    }

}