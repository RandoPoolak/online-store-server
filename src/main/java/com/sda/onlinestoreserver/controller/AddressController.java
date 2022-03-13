package com.sda.onlinestoreserver.controller;
import com.sda.onlinestoreserver.exceptions.AddressNotFoundException;
import com.sda.onlinestoreserver.models.Address;
import com.sda.onlinestoreserver.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        try {
            Address address = addressService.findById(id);
            return new ResponseEntity<>(address, HttpStatus.FOUND);

        } catch (AddressNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @PostMapping("/update")
    public void updateAddress(@RequestBody Address address) {
        try{
            addressService.updateAddress(address);
        }catch (AddressNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public void deleteAddress(@PathVariable("id") long id) {
        try{
            addressService.deleteAddressById(id);
        }catch (AddressNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @GetMapping("/restore/{id}")
    public void restoreAddress(@PathVariable("id") long id) {
        try{
            addressService.restoreAddressById(id);
        }catch (AddressNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @PostMapping("/create")
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }
}
