package com.ing.mortgage.services.application;

import org.springframework.stereotype.Service;

/*
 * Service Implementation for Mortgage service.
 * @author : Himanshu
 */

@Service
public class MortgageServiceImpl implements MortgageService{
    /*
        Api to calculate per month EMI .
		Loan Payment = Amount / Discount Factor
		or
        P = amount / discountFactor
        Number of Periodic Payments (n) = Payments per year times number of years
        Periodic Interest Rate (i) = Annual rate divided by number of payments per
        Discount Factor (D) = {[(1 + i) ^n] - 1} / [i(1 + i)^n]

		@param amount Credit amount
		@param months Credit tenure
		@param interest Credit interest rate
		@return Calculated amount.
     */
    @Override
    public Double calculateEMI(final String amount,final Integer months,final String interest) {

        //interest is annual
        Double i = Double.parseDouble(interest)/1200;

        Double x = Math.pow(1+i,months) ;

        Double discountFactor = (x-1)/(i*x) ;

        return Double.parseDouble(amount)/discountFactor;
    }
}
