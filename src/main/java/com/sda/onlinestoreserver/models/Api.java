package com.sda.onlinestoreserver.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String apiKey;

    private String identifier;

    public Api(){
        super();
    }

    public Api(Long id, String apiKey, String identifier){
        this.id = id;
        this.apiKey = apiKey;
        this.identifier = identifier;
    }
}
