package com.surittec.springboot.services;

import java.util.List;

import com.surittec.springboot.exception.ResourceNotFoundException;
import com.surittec.springboot.model.Phone;
import com.surittec.springboot.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public List<Phone> getPhones() {
        return phoneRepository.findAll();
    }

    public Phone getPhoneById(Long id) throws Exception {
        return phoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Telefone com id: " + id + " nao encontrado"));
    }

    public Phone deletePhone(Long id) throws Exception {
        Phone phone = getPhoneById(id);
        phoneRepository.delete(phone);
        return phone;
    }

    public Phone updatePhone(Long id, Phone phone) throws Exception {
        Phone phoneToEdit = getPhoneById(id);
        phoneToEdit.setNumber(phone.getNumber());
        phoneToEdit.setType(phone.getType());
        return phoneToEdit;
    }

}
