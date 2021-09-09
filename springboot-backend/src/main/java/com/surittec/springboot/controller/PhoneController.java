package com.surittec.springboot.controller;

import com.surittec.springboot.model.Phone;
import com.surittec.springboot.model.dto.PhoneDto;
import java.util.List;
import java.util.stream.Collectors;

import com.surittec.springboot.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping
    public ResponseEntity<PhoneDto> createPhone(@RequestBody final PhoneDto phoneDto) {
        Phone phone = phoneService.addPhone(Phone.from(phoneDto));
        return new ResponseEntity<>(PhoneDto.from(phone), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PhoneDto>> getPhones() {
        List<Phone> phones = phoneService.getPhones();
        List<PhoneDto> phonesDto = phones.stream().map(PhoneDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(phonesDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PhoneDto> getPhoneById(@PathVariable final Long id) throws Exception{
        Phone phone = phoneService.getPhoneById(id);
        return new ResponseEntity<>(PhoneDto.from(phone), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<PhoneDto> deletePhoneById(@PathVariable final Long id) throws Exception {
        Phone phone = phoneService.deletePhone(id);
        return new ResponseEntity<>(PhoneDto.from(phone), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<PhoneDto> updatePhoneById(@PathVariable final Long id, @RequestBody final PhoneDto phoneDto) throws Exception {
        Phone phone = phoneService.updatePhone(id, Phone.from(phoneDto));
        return new ResponseEntity<>(PhoneDto.from(phone), HttpStatus.OK);
    }
}
