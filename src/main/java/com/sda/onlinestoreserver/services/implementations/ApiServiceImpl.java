package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.models.Api;
import com.sda.onlinestoreserver.repository.ApiRepository;
import com.sda.onlinestoreserver.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApiServiceImpl implements ApiService {
    @Autowired
    private ApiRepository apiRepository;

    @Override
    public void createApiInfo() {
        Api api = new Api(0L, "6cee3d989c995daebcf466b61fb2ccf2", "weather");
        apiRepository.save(api);
    }

    @Override
    public List<Api> getAllApiInfo() {
        return apiRepository.findAll();
    }
}
