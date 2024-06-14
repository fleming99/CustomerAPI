package com.fleming99.CustomerAPI.application;

import com.fleming99.CustomerAPI.adapters.CustomerAddressRepository;
import com.fleming99.CustomerAPI.core.entities.CustomerAddress;
import com.fleming99.CustomerAPI.core.usecases.AddressesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerAddressServiceImpl implements AddressesUseCase {

    private final CustomerAddressRepository customerAddressRepository;

    @Autowired
    public CustomerAddressServiceImpl(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }

    @Override
    public List<CustomerAddress> addressesList() {
        return customerAddressRepository.findAll();
    }

    @Override
    public CustomerAddress findAddressById(long id) {

        Optional<CustomerAddress> address = customerAddressRepository.findById(id);

        if (address.isEmpty()){
            throw new RuntimeException("Did not found the address by id" + id);
        }

        return address.get();
    }

    @Override
    public CustomerAddress createCustomerAddress(CustomerAddress customerAddress) {
        return customerAddressRepository.save(customerAddress);
    }

    @Override
    public void deleteAddressById(long id) {
        customerAddressRepository.deleteById(id);
    }

    @Override
    public void deleteAddress(CustomerAddress customerAddress) {
        customerAddressRepository.delete(customerAddress);
    }
}
