package com.surittec.springboot.controller;

import com.surittec.springboot.model.Phone;
import com.surittec.springboot.model.dto.PhoneDto;
import java.util.List;
import java.util.stream.Collectors;

import com.surittec.springboot.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PhoneDto> createPhone(@RequestBody final PhoneDto phoneDto) {
        return buildResponse(() -> phoneService.addPhone(Phone.from(phoneDto)));
    }

    @GetMapping
    public ResponseEntity<List<PhoneDto>> getPhones() {
        return buildResponse(() -> {
            List<Phone> phones = phoneService.getPhones();
            List<PhoneDto> phonesDto = phones.stream().map(PhoneDto::from).collect(Collectors.toList());
            return phonesDto;
        });
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PhoneDto> getPhoneById(@PathVariable final Long id) {
        return buildResponse(() -> phoneService.getPhoneById(id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deletePhoneById(@PathVariable final Long id) {
        return buildResponse(() -> phoneService.deletePhone(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<PhoneDto> updatePhoneById(@PathVariable final Long id, @RequestBody final PhoneDto phoneDto) {
        return buildResponse(() -> phoneService.updatePhone(id, Phone.from(phoneDto)));
    }
}
