package com.fleming99.CustomerAPI.core.usecases;

import com.fleming99.CustomerAPI.core.dto.CustomerDTO;
import com.fleming99.CustomerAPI.core.entities.Customer;

import java.util.List;

public interface CustomerUseCase {

    List<Customer> customersList();

    Customer createCustomer(CustomerDTO customerDTO);

    Customer updateCustomer(CustomerDTO customerDTO);

    Customer findCustomerById(long id);

    void deleteCustomerById(long id);
}
