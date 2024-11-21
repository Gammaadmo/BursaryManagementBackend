package org.biic0.org.repository;

import org.biic0.org.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> findAddressByAddressIdAndStreetNameAndZipCode(String addressId);

}
