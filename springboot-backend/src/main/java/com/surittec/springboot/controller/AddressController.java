package com.surittec.springboot.controller;

import com.surittec.springboot.converters.AddressConverter;
import com.surittec.springboot.model.Address;
import com.surittec.springboot.dto.AddressDTO;
import com.surittec.springboot.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody final AddressDTO addressDto) {
        return buildResponse(() -> addressService.addAddress(AddressConverter.convertAddressDTOToAddress(addressDto)));
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAddress() {
        return buildResponse(() -> {
            List<Address> addresses = addressService.getAddress();
            List<AddressDTO> addressDtos = addresses.stream().map(AddressConverter::convertAddressToAddressDTO).collect(Collectors.toList());
            return addressDtos;
        });

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable final Long id) {
        return buildResponse(() -> addressService.getAddressById(id));
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteAddressById(@PathVariable final Long id) {
        return buildResponse(() -> addressService.deleteAddress(id));
    }

    @PutMapping(value = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AddressDTO> updateAddressById(@PathVariable final Long id, @RequestBody final AddressDTO addressDto) {
        return buildResponse(() -> addressService.updateAddress(id, AddressConverter.convertAddressDTOToAddress(addressDto)));
    }

}
