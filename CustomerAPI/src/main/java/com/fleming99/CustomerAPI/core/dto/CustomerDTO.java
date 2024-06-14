package com.fleming99.CustomerAPI.core.dto;

public record CustomerDTO(long id, String firstName, String lastName, String birthDate, String email,
                          String password, String cep, String streetName, String houseNumber, String neighborhood,
                          String city, String state, String country) {
}
