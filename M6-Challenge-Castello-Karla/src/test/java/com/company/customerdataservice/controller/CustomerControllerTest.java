package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @MockBean
    CustomerRepository customerRepository;

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper objectMapper;

    private Customer customer;

    @Test
    public void shouldReturnAllCustomers() throws Exception{

        mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAddCustomer() throws Exception{
        customer = new Customer();
        customer.setFirstName("Bob");
        customer.setLastName("Ross");
        customer.setEmail("bob@yahoo.com");
        customer.setPhone("1-(808)-888-8888");
        customer.setAddress1("123 Lane Street");
        customer.setAddress2("House 2");
        customer.setPostalCode("12345");
        customer.setCity("Houston");
        customer.setState("Texas");
        customer.setCountry("United States");
        customer.setCompany("New Paints");

        String inputJson = objectMapper.writeValueAsString(customer);

        mockMvc.perform(post("/customers").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());


    }

    @Test
    public void shouldDeleteCustomer() throws Exception{
        mockMvc.perform(delete("/customers/{id}", "5"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetCustomerById() throws Exception{
        mockMvc.perform(get("/customers/6"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldGetCustomerByState() throws Exception{
        mockMvc.perform(get("/customers/state/California"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldUpdateCustomer() throws Exception{
        customer.setFirstName("Robert");

        String inputJson = objectMapper.writeValueAsString(customer);

        mockMvc.perform(put("/customers").content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }



}