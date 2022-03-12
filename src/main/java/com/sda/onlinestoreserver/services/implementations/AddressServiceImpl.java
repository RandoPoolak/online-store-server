package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.AddressNotFoundException;
import com.sda.onlinestoreserver.models.Address;
import com.sda.onlinestoreserver.repository.AddressRepository;
import com.sda.onlinestoreserver.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddressById(Long id) throws AddressNotFoundException {
        Address address = findById(id);
        address.setActive(false);
        addressRepository.saveAndFlush(address);
    }

    @Override
    public Address findById(Long id) throws AddressNotFoundException {
        Optional<Address> addressOptional = addressRepository.findById(id);

        if (addressOptional.isEmpty()) {
            throw new AddressNotFoundException(id);
        }

        return addressOptional.get();
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void updateAddress(Address address) throws AddressNotFoundException {
        if (findById(address.getId()) != null){
            addressRepository.saveAndFlush(address);
        }
    }
}
