package com.sda.onlinestoreserver.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Login {
    @JsonProperty("email")
    private String email;
    @JsonProperty("pass")
    private String pass;

    public Login(){
        super();
    }

    public Login(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
}
