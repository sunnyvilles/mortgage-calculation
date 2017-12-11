package com.ing.mortgage.services.application;

import com.ing.mortgate.entities.user.User;
import com.ing.mortgage.utils.AuthConstant;
import com.ing.mortgage.utils.AuthUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static User user = new User();

    static {
        user.setUsername("jones");
        String hash = AuthUtils.generateHash(AuthConstant.SALT + "indiana");
        user.setHash(hash);
    }

    @Override
    public User authenticate(String userName, String password) {
        String inputHash = AuthUtils.generateHash(AuthConstant.SALT + password);
        if(user.getUsername().equals(userName) && user.getHash().equals(inputHash)){
                    return user;
        }
        return null;
    }
}
