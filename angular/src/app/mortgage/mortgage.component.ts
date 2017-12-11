import { Component} from '@angular/core';
import { MortgageService } from '../../services/services.module';

@Component({

    templateUrl: 'mortgage.component.html'
})

export class MortgageComponent  {

    values: any = {};
    error: string;
    resultValue: string = '0'; 
	
	constructor(private mortgageService: MortgageService) {}

	calcMortgage(){

         this.mortgageService.calcMortgage(this.values.amount, this.values.month, this.values.interest)
            .subscribe(result => {
                this.resultValue = this.getTwoFixedDecimal(result['data']);
            });

	}

	getTwoFixedDecimal(val:number):string{
		return Number(val).toFixed(2);
	}

}