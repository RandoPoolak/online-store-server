package com.sda.onlinestoreserver.controller;
import com.sda.onlinestoreserver.models.Address;
import com.sda.onlinestoreserver.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/get_by_id/{id}")
    public Address getById(@PathVariable("id") long id) {
        return addressRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @PostMapping("/update")
    public void updateAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @GetMapping("/delete/{id}")
    public void deleteAddress(@PathVariable("id") long id) {
        addressRepository.deleteById(id);
    }

    @PostMapping("/save")
    public void saveAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }
}
