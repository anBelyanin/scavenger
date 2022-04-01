package com.warehouse.scavenger.common.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "token",
        "status"
})
public class AuthResponse {
}
