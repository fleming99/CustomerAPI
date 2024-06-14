package com.fleming99.CustomerAPI.controllers;

import com.fleming99.CustomerAPI.application.CustomerServiceImpl;
import com.fleming99.CustomerAPI.core.dto.CustomerDTO;
import com.fleming99.CustomerAPI.core.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Customer> customersList(){
        try{
            return customerService.customersList();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.getCause());
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable long id){
        try {
            return customerService.findCustomerById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.getCause());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO){
        try{
            return customerService.createCustomer(customerDTO);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.getCause());
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@PathVariable long id, @RequestBody CustomerDTO customerDTO){
        try {
            return customerService.updateCustomer(customerDTO);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.getCause());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomerById(@PathVariable long id){
        try{
            customerService.deleteCustomerById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.getCause());
        }
    }
}
