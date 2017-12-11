package com.ing.mortgage.services.application;


public interface MortgageService {
    public Double calculateEMI(String amount, Integer months, String interest);
}
