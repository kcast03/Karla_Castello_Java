package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //post - creates new customer
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer){return customerRepository.save(customer);}

    //put - updates existing customer
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer){customerRepository.save(customer);}

    //delete - deletes existing customer
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id){customerRepository.deleteById(id);}

    //get all
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){return customerRepository.findAll();}

    //get by id
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable Integer id){
        Optional<Customer> returnVal = customerRepository.findById(id);
        if (returnVal.isPresent()){
            return returnVal.get();
        } else{
            return null;
        }
    }

    //get by state
    @GetMapping("/customers/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomerByState(@PathVariable String state) {
        List<Customer> returnList = customerRepository.findByState(state);
        return returnList;
    }
}
