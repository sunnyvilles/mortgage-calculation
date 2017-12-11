package com.ing.mortgage.services.application;

import com.ing.mortgate.entities.user.User;

public interface AuthenticationService {

    public User authenticate(String userName, String password);
}
