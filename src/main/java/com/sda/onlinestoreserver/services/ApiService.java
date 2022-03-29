package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.models.Api;

import java.util.List;

public interface ApiService {

    /**
     * Create api info
     */
    void createApiInfo();

    /**
     * Get all api info's
     */
    List<Api> getAllApiInfo();
}
