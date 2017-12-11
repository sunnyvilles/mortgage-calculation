import { MortgageComponent } from './mortgage.component';
import { MortgageService } from '../../services/services.module';

describe('MortgageComponent', () => {


  it ('it should fix a number to two decimal places', () => {
   	
   	let service : MortgageService;
   	let component = new MortgageComponent(service);

   	expect(component.getTwoFixedDecimal(2.23456)).toBe(2.23);

  });

});