package org.biic0.org.service;

import org.biic0.org.domain.Address;
import org.biic0.org.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address read(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }
    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public List<Address> findAddressByAddressIdAndStreetNameAndZipCode(String addressId, String streetName, String zipCode) {
        return addressRepository.findAddressByAddressIdAndStreetNameAndZipCode(addressId, streetName, zipCode);
    }

}
