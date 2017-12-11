import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map'

import { ApiEndPoint } from '../app/shared/ApiEndPoint'

@Injectable()
export class LoginService {

    public auth: string;

    constructor(private http: Http) {
        // if token is already present
        let userInfo: string = JSON.parse(localStorage.getItem('userInfo'));

        if(userInfo){
            this.auth = userInfo['token'];
        }
        
    }

    /*
        authenticate the user and password
    */
    authenticate(username: string, password: string): Observable<boolean> {

        let params = new URLSearchParams();

        params.append("username", username);
        params.append("password", password);

        let getUrl = '/auth/login?'+params.toString();
        //let getUrl = ApiEndPoint['loginService'];

        return this.http.get(getUrl)
            .map((response: Response) => {
                 
                let token: string ;

                if(response.json()) token = response.json().data;

                if (token) {

                    this.auth = token;
                    localStorage.setItem('userInfo', JSON.stringify({ username: username, token: token }));

                    // success
                    return true;
                } else {
                    // failure
                    return false;
                }
            });
    }


    removeUser(): void {

        this.auth = null;
        localStorage.removeItem('userInfo');
    }

}