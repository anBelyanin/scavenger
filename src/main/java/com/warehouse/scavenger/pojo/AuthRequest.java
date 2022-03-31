package com.warehouse.scavenger.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "login",
    "password"
    })
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequest {

    @JsonProperty(value = "login")
    public String login;

    @JsonProperty(value = "password")
    public String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
