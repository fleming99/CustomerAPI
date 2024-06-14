package com.fleming99.CustomerAPI.adapters;

import com.fleming99.CustomerAPI.core.entities.CustomerRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRolesRepository extends JpaRepository<CustomerRoles, Long> {

    @Query("SELECT r FROM CustomerRoles r WHERE r.roleName = ?1")
    CustomerRoles findRoleByName (String roleName);
}
