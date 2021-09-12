package com.surittec.springboot.services;

import com.surittec.springboot.exception.ResourceNotFoundException;
import com.surittec.springboot.model.Address;
import com.surittec.springboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(@Valid Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) throws Exception {
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Endereco com id: " + id + " nao encontrado"));
    }

    public void deleteAddress(Long id) throws Exception {
        Address address = getAddressById(id);
        addressRepository.delete(address);
    }

    @Transactional
    public Address updateAddress(Long id, @Valid Address address) throws Exception {
        Address addressToEdit = getAddressById(id);
        addressToEdit.setCep(address.getCep());
        addressToEdit.setCity(address.getCity());
        addressToEdit.setComplement(address.getComplement());
        addressToEdit.setNeighborhood(address.getNeighborhood());
        addressToEdit.setState(address.getState());
        addressToEdit.setStreet(address.getStreet());
        return addressToEdit;
    }
}
