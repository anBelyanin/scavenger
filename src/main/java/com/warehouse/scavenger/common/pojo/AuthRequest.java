package com.warehouse.scavenger.common.pojo;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({
    "login",
    "password"
    })
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequest {

    @JsonProperty(value = "login")
    private String login;

    @JsonProperty(value = "password")
    private String password;

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
