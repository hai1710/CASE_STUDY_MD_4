package com.demo.controller;

import com.demo.model.Address;

import com.demo.service.Address.IAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> showAddressList() {
        List<Address> addressList = (List<Address>) addressService.findAll();
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.findById(id);
        if (!address.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> addNewCompany(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.save(address), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address){
        Optional<Address> addressOptional = addressService.findById(id);
        if (!addressOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        address.setId(addressOptional.get().getId());
        return new ResponseEntity<>(addressService.save(address),HttpStatus.OK);
    }
}
