package com.fleming99.CustomerAPI.application;

import com.fleming99.CustomerAPI.adapters.CustomerRolesRepository;
import com.fleming99.CustomerAPI.core.entities.CustomerRoles;
import com.fleming99.CustomerAPI.core.usecases.CustomerRolesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRolesServiceImpl implements CustomerRolesUseCase {

    private final CustomerRolesRepository customerRolesRepository;

    @Autowired
    public CustomerRolesServiceImpl(CustomerRolesRepository customerRolesRepository) {
        this.customerRolesRepository = customerRolesRepository;
    }

    @Override
    public CustomerRoles findRoleByName(String roleName) {
        return customerRolesRepository.findRoleByName(roleName);
    }
}
