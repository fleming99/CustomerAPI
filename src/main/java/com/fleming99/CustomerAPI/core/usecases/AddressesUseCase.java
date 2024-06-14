package com.fleming99.CustomerAPI.core.usecases;

import com.fleming99.CustomerAPI.core.entities.Customer;
import com.fleming99.CustomerAPI.core.entities.CustomerAddress;

import java.util.List;

public interface AddressesUseCase {

    List<CustomerAddress> addressesList();

    CustomerAddress findAddressById(long id);

    CustomerAddress createCustomerAddress(CustomerAddress customerAddress);

    void deleteAddressById(long id);

    void deleteAddress(CustomerAddress customerAddress);
}
