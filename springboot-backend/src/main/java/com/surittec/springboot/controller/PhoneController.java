package com.surittec.springboot.controller;

import com.surittec.springboot.converters.PhoneConverter;
import com.surittec.springboot.model.Phone;
import com.surittec.springboot.dto.PhoneDTO;
import java.util.List;
import java.util.stream.Collectors;

import com.surittec.springboot.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneController extends AbstractController{

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PhoneDTO> createPhone(@RequestBody final PhoneDTO phoneDto) {
        return buildResponse(() -> phoneService.addPhone(PhoneConverter.convertPhoneDTOTOPhone(phoneDto)));
    }

    @GetMapping
    public ResponseEntity<List<PhoneDTO>> getPhones() {
        return buildResponse(() -> {
            List<Phone> phones = phoneService.getPhones();
            List<PhoneDTO> phonesDto = phones.stream().map(PhoneConverter::convertPhoneToPhoneDTO).collect(Collectors.toList());
            return phonesDto;
        });
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PhoneDTO> getPhoneById(@PathVariable final Long id) {
        return buildResponse(() -> phoneService.getPhoneById(id));
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deletePhoneById(@PathVariable final Long id) {
        return buildResponse(() -> phoneService.deletePhone(id));
    }

    @PutMapping(value = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PhoneDTO> updatePhoneById(@PathVariable final Long id, @RequestBody final PhoneDTO phoneDto) {
        return buildResponse(() -> phoneService.updatePhone(id, PhoneConverter.convertPhoneDTOTOPhone(phoneDto)));
    }
}
