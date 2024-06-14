package com.fleming99.CustomerAPI.core.usecases;

import com.fleming99.CustomerAPI.core.entities.CustomerRoles;

public interface CustomerRolesUseCase {

    CustomerRoles findRoleByName(String roleName);
}
