package com.fleming99.CustomerAPI.application;

import com.fleming99.CustomerAPI.adapters.CustomerAddressRepository;
import com.fleming99.CustomerAPI.adapters.CustomerRepository;
import com.fleming99.CustomerAPI.adapters.CustomerRolesRepository;
import com.fleming99.CustomerAPI.core.dto.CustomerDTO;
import com.fleming99.CustomerAPI.core.entities.Customer;
import com.fleming99.CustomerAPI.core.entities.CustomerAddress;
import com.fleming99.CustomerAPI.core.usecases.CustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerRolesRepository customerRolesRepository;
    private final CustomerAddressRepository customerAddressRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerRolesRepository customerRolesRepository, CustomerAddressRepository customerAddressRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.customerRolesRepository = customerRolesRepository;
        this.customerAddressRepository = customerAddressRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Customer> customersList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer();

        customer.setCustomerFirstName(customerDTO.firstName());
        customer.setCustomerLastName(customerDTO.lastName());
        customer.setCustomerBirthDate(LocalDate.parse(customerDTO.birthDate()));
        customer.setCustomerRegDate(LocalDateTime.now());
        customer.setCustomerEmail(customerDTO.email());
        customer.setCustomerPassword(passwordEncoder.encode(customerDTO.password()));
        customer.setActiveProfile(true);
        customer.setCustomerRole(Collections.singletonList(customerRolesRepository.findRoleByName("ROLE_CUSTOMER")));
        customerRepository.save(customer);

        CustomerAddress address = new CustomerAddress();

        address.setCep(customerDTO.cep());
        address.setStreetName(customerDTO.streetName());
        address.setHouseNumber(customerDTO.houseNumber());
        address.setNeighborhood(customerDTO.neighborhood());
        address.setCity(customerDTO.city());
        address.setState(customerDTO.state());
        address.setCountry(customerDTO.country());
        address.setCustomer(customer);
        customerAddressRepository.save(address);

        return customer;
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO) {

        Customer customer = findCustomerById(customerDTO.id());

        customer.setCustomerFirstName(customerDTO.firstName());
        customer.setCustomerLastName(customerDTO.lastName());
        customer.setCustomerBirthDate(LocalDate.parse(customerDTO.birthDate()));
        customer.setCustomerEmail(customerDTO.email());
        customer.setCustomerPassword(passwordEncoder.encode(customerDTO.password()));
        customerRepository.save(customer);

        return customer;
    }

    @Override
    public Customer findCustomerById(long id) {

        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isEmpty()){
            throw new RuntimeException("Did not found the customer by id" + id);
        }

        return customer.get();
    }

    @Override
    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }
}
