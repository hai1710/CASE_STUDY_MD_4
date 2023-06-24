package com.demo.controller;

import com.demo.model.Location;

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
    public ResponseEntity<List<Location>> showAddressList() {
        List<Location> locationList = (List<Location>) addressService.findAll();
        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> findAddressById(@PathVariable Long id) {
        Optional<Location> address = addressService.findById(id);
        if (!address.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Location> addNewCompany(@RequestBody Location location) {
        return new ResponseEntity<>(addressService.save(location), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateAddress(@PathVariable Long id, @RequestBody Location location){
        Optional<Location> addressOptional = addressService.findById(id);
        if (!addressOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        location.setId(addressOptional.get().getId());
        return new ResponseEntity<>(addressService.save(location),HttpStatus.OK);
    }
}
