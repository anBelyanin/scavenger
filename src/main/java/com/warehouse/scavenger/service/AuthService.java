package com.warehouse.scavenger.service;

import com.warehouse.scavenger.common.Constants;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private String status;
    private String token;

    private static Map<String, String> initiateUsers() {
        Map<String, String> users = new HashMap<>();
        users.put("admin", DigestUtils.sha256Hex("adminpassword"));
        users.put("user", DigestUtils.sha256Hex("userpassword"));
        return users;
    }

    private static Map<String, String> USERS = AuthService.initiateUsers();

    public String processAuth(String login, String password) {
        String encryptPassword = DigestUtils.sha256Hex(password);
        if (USERS.containsKey(login) && USERS.containsValue(encryptPassword)) {
            status = Constants.AUTH_SUCCESS_RESULT;
        } else {
            status = Constants.AUTH_UNSUCCESS_RESULT;
        }
        return status;
    }
}
