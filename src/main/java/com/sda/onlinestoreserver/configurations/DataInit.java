package com.sda.onlinestoreserver.configurations;

import com.sda.onlinestoreserver.models.Address;
import com.sda.onlinestoreserver.models.ContactMethod;
import com.sda.onlinestoreserver.models.Role;
import com.sda.onlinestoreserver.models.User;
import com.sda.onlinestoreserver.services.ApiService;
import com.sda.onlinestoreserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit {

    @Autowired
    private ApiService apiService;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        String email = "admin@admin.com";
        String pass = "ADMIN";

        initApi();
        initAdminUser(email, pass);
    }

    private void initApi(){
        if(apiService.getAllApiInfo().isEmpty()){
            apiService.createApiInfo();
        }
    }

    private void initAdminUser(String email, String pass){
        if(userService.getAllAdmins().isEmpty()){
            User user = new User();
            user.setActive(true);
            user.setAddresses(createAddresses());
            user.setId(0L);
            user.setUserName("System Admin");
            user.setEmail(email);
            user.setLogoUrl("https://cdn.worldvectorlogo.com/logos/sys-admin.svg");
            user.setPassword(pass);
            user.setRole(Role.ADMIN);
            user.setContactMethod(ContactMethod.EMAIL);

            userService.createUser(user);
        }
    }

    private List<Address> createAddresses(){
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setActive(true);
        address.setDefaultAddress(true);
        address.setCity("Tallinn");
        address.setCountry("Estonia");
        address.setZipCode("1234");
        address.setStreet("Street");
        address.setId(0L);

        addresses.add(address);
        return addresses;
    }
}
