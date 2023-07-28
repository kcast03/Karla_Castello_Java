package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp(){
        customerRepository.deleteAll();
    }

    @Test
    public void shouldAddCustomer(){
        // Arrange
        Customer customer = new Customer();
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

        customerRepository.save(customer);

        // Act
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        // Assert
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer(){

        // Arrange
        Customer customer = new Customer();
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
        customerRepository.save(customer);

        //Act
        customer.setFirstName("Robert");
        customer.setAddress2("New Address 2");
        customer.setPhone("1-(201)-000-0000");
        customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        //Assert
        assertEquals(customer1.get(), customer);




    }

    @Test
    public void shouldGetCustomerById(){

        // Arrange
        Customer customer = new Customer();
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
        customerRepository.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Aubrey");
        customer2.setLastName("Graham");
        customer2.setEmail("drake.com");
        customer2.setPhone("1-(111)-111-1111");
        customer2.setAddress1("166 Street");
        customer2.setAddress2("House 1");
        customer2.setPostalCode("60666");
        customer2.setCity("Los Angeles");
        customer2.setState("California");
        customer2.setCountry("United States");
        customer2.setCompany("OVO");
        customerRepository.save(customer2);

        //Act

        Optional<Customer> foundCustomer = customerRepository.findById(customer.getId());

        // Assert
        assertEquals(foundCustomer.get(), customer);


    }

    @Test
    public void shouldDeleteCustomer(){

        // Arrange
        Customer customer = new Customer();
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
        customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);

        // Act
        customerRepository.deleteById(customer.getId());

        customer1 = customerRepository.findById(customer.getId());

        //Assert
        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldFindCustomerByState(){

        // Arrange
        Customer customer = new Customer();
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
        customerRepository.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Aubrey");
        customer2.setLastName("Graham");
        customer2.setEmail("drake.com");
        customer2.setPhone("1-(111)-111-1111");
        customer2.setAddress1("166 Street");
        customer2.setAddress2("House 1");
        customer2.setPostalCode("60666");
        customer2.setCity("Los Angeles");
        customer2.setState("California");
        customer2.setCountry("United States");
        customer2.setCompany("OVO");
        customerRepository.save(customer2);

        // Act
        List<Customer> cList = customerRepository.findByState("Texas");

        //Assert
        assertEquals(cList.size(), 1);



    }

}
