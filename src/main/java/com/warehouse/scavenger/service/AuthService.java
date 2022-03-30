package com.warehouse.scavenger.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private static Map<String, String> initiateUsers() {
        Map<String, String> users = new HashMap<>();
        users.put("admin", DigestUtils.sha256Hex("adminpassword"));
        users.put("user", DigestUtils.sha256Hex("userpassword"));
        return users;
    }

    private static Map<String, String> USERS = AuthService.initiateUsers();

    public String processAuth(String login, String password) {
        String response = (USERS.containsKey(login) && USERS.containsValue(DigestUtils.sha256Hex(password))) ? login + " authorized" : login + " unauthorized";
        return response;
    }
}
