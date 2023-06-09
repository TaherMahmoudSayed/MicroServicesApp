package com.amigoscode.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer customerRegistration(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer= Customer.builder()
                .firstName(customerRegistrationRequest.firstName)
                .lastName(customerRegistrationRequest.lastName)
                .email(customerRegistrationRequest.email).build();
        // TODO: check if  email is valid
        // TODO: check if it's taken
        // TODO: store customer in db
        customerRepository.save(customer);
        return customer;

    }
}
