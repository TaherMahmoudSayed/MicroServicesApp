package com.microservice.service;

import com.microservice.entity.Customer;
import com.microservice.repository.CustomerRepository;
import com.microservice.requestResponceDTO.CustomerRegistrationRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.cert.Extension;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerRegistrationRequestDTO registerCustomer(CustomerRegistrationRequestDTO customerDTO){
        var customer=Customer.builder().firstName(customerDTO.firstName())
                .email(customerDTO.email())
                .lastName(customerDTO.lastName()).build();
        try {
            customerRepository.save(customer);

            return customerDTO;

        }catch (Exception ex){
            return null;
        }
        }
}
