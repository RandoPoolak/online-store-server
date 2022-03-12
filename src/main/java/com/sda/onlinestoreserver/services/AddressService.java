package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.AddressNotFoundException;
import com.sda.onlinestoreserver.models.Address;

import java.util.List;

public interface AddressService {
    /**
     * To create a new address
     * @param address Address
     */
    void createAddress(Address address);

    /**
     * To delete address by its id
     * @param id Address id
     */
    void deleteAddressById(Long id) throws AddressNotFoundException;

    /**
     * To find order by its id
     * @param id Address id
     * @return address by id
     * @throws AddressNotFoundException if no address
     */
    Address findById(Long id) throws AddressNotFoundException;

    /**
     * To get all addresses
     * @return all addresses
     */
    List<Address> getAll();


    /**
     * To update existing address
     * @param address modified address
     */
    void updateAddress(Address address) throws AddressNotFoundException;
}
