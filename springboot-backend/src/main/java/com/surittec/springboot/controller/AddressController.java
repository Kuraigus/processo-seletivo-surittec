package com.surittec.springboot.controller;

import com.surittec.springboot.model.Address;
import com.surittec.springboot.model.dto.AddressDto;
import com.surittec.springboot.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController extends AbstractController{

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody final AddressDto addressDto) {
        return buildResponse(() -> addressService.addAddress(Address.from(addressDto)));
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAddress() {
        return buildResponse(() -> {
            List<Address> addresses = addressService.getAddress();
            List<AddressDto> addressDtos = addresses.stream().map(AddressDto::from).collect(Collectors.toList());
            return addressDtos;
        });

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable final Long id) {
        return buildResponse(() -> addressService.getAddressById(id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable final Long id) {
        return buildResponse(() -> addressService.deleteAddress(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AddressDto> updateAddressById(@PathVariable final Long id, @RequestBody final AddressDto addressDto) {
        return buildResponse(() -> addressService.updateAddress(id, Address.from(addressDto)));
    }

}
