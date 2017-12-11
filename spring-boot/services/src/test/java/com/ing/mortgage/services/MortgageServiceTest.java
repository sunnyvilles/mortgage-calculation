package com.ing.mortgage.services;

import com.ing.mortgage.services.application.MortgageService;
import com.ing.mortgage.services.application.MortgageServiceImpl;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MortgageServiceTest {

    MortgageService mortgageService = mock(MortgageServiceImpl.class);

    @Test
    public void calculateEMITest(){
        when(mortgageService.calculateEMI(anyString(),anyInt(),anyString())).thenReturn(55.7D);
        Double emi = mortgageService.calculateEMI(String.valueOf(100),10,String.valueOf(5));
        assertEquals( String.valueOf(55.7),emi.toString());
    }
}
