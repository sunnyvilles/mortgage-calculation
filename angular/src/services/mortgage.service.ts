import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map'

import { ApiEndPoint } from '../app/shared/ApiEndPoint'

@Injectable()
export class MortgageService {

    public auth: string;

    constructor(private http: Http) {

    }

    calcMortgage(amount: string, month: string, interest: string): Observable<boolean> {

        let params = new URLSearchParams();

        params.append("amount", amount);
        params.append("month", month);
        params.append("interest", interest);

        let getUrl = 'api/mortgage/calculate?'+params.toString();

        //let getUrl = ApiEndPoint['mortgageService'];

        const headers = new Headers();
        headers.append('Authorization', this.getAuthHeader());

        const options = new RequestOptions({headers: headers});

        return this.http.get(getUrl, options)
            .map((response: Response) => {
                return response.json();
            });
    }


    getAuthHeader(): string {

        return "Bearer " + JSON.parse(localStorage.getItem("userInfo")).token;
    }
}