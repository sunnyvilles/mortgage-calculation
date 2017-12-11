package com.ing.mortgage.web.rs;

import com.ing.mortgage.web.response.ResponseBuilder;
import com.ing.mortgage.web.response.ResponseEntity;
import com.ing.mortgage.services.application.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/mortgage")
public class MortgageRestService {

    @Autowired
    MortgageService mortgageService;

    @RequestMapping(value = "/calculate",
            method = RequestMethod.GET,
             produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity calculateEMI(@RequestParam(value = "amount") String amount,
                                       @RequestParam(value = "month") Integer months,
                                       @RequestParam(value = "interest") String interest) {

        if (amount == null || months == null || interest== null) {
            return ResponseBuilder.buildErrorResponse("Invalid input");
        }
        Double emi = null;
        try {
             emi = mortgageService.calculateEMI(amount,months,interest);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBuilder.buildErrorResponse(e.getMessage());
        }
        return ResponseBuilder.buildSucessResponse(emi);
    }

}
