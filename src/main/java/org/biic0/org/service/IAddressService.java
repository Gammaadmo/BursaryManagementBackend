package org.biic0.org.service;

import org.biic0.org.domain.Address;

import java.util.List;

public interface IAddressService extends IService<Address,String>{
    List<Address> getAll();
}
