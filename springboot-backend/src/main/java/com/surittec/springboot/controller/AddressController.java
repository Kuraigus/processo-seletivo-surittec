package com.surittec.springboot.controller;

import com.surittec.springboot.model.Address;
import com.surittec.springboot.model.dto.AddressDto;
import com.surittec.springboot.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody final AddressDto addressDto) {
        Address address = addressService.addAddress(Address.from(addressDto));
        return new ResponseEntity<>(AddressDto.from(address), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAddress() {
        List<Address> addresses = addressService.getAddress();
        List<AddressDto> addressDtos = addresses.stream().map(AddressDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(addressDtos, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable final Long id) throws Exception{
        Address address = addressService.getAddressById(id);
        return new ResponseEntity<>(AddressDto.from(address), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<AddressDto> deleteAddressById(@PathVariable final Long id) throws Exception {
        Address address = addressService.deleteAddress(id);
        return new ResponseEntity<>(AddressDto.from(address), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AddressDto> updateAddressById(@PathVariable final Long id, @RequestBody final AddressDto addressDto) throws Exception {
        Address address = addressService.updateAddress(id, Address.from(addressDto));
        return new ResponseEntity<>(AddressDto.from(address), HttpStatus.OK);
    }

}
