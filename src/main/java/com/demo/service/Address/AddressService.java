package com.demo.service.Address;

import com.demo.model.Location;
import com.demo.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements IAddressService{
    @Autowired
    private IAddressRepository addressRepository;

    @Override
    public Iterable<Location> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Location save(Location location) {
        return addressRepository.save(location);
    }

    @Override
    public void remove(Long id) {
    addressRepository.deleteById(id);
    }
}
