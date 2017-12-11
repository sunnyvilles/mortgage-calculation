package com.ing.mortgage.web.rs;

import com.ing.mortgage.web.response.ResponseBuilder;
import com.ing.mortgage.web.response.ResponseEntity;
import com.ing.mortgate.entities.user.User;
import com.ing.mortgage.services.application.AuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@RestController
@RequestMapping(value ="/auth")
public class AuthService {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity authenticate(@RequestParam(value = "username") String username,
                                       @RequestParam(value = "password") String password) {

        if (username == null || password == null)
            return ResponseBuilder.buildErrorResponse("Username or Password is missing");

        User user = authenticationService.authenticate(username, password);

        if (user != null) {
            String token = Jwts.builder().setSubject(user.getUsername())
                    .claim("username", user.getUsername()).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            return ResponseBuilder.buildSucessResponse(token);

        }
        return ResponseBuilder.buildErrorResponse("Username or Password is incorrect");
    }
}
