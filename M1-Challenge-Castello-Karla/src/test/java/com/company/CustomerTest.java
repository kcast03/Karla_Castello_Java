package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer customer;

    @BeforeEach
    public void setUp(){
        customer = new Customer();
    }

    @Test
    public void getZeroBalance(){

        assertEquals(0, customer.getBalance());
    }

    @Test
    public void getNegativeBalance(){

        AccountRecord ar = new AccountRecord();
        ar.setCharge(-100);
        customer.getCharges().add(ar);

        assertEquals(-100, customer.getBalance());
    }


    @Test
    public void getPositiveBalance(){

        AccountRecord ar1 = new AccountRecord();
        AccountRecord ar2 = new AccountRecord();

        ar1.setCharge(-10);
        ar2.setCharge(50);

        customer.getCharges().add(ar1);
        customer.getCharges().add(ar2);

        assertEquals(40, customer.getBalance());
    }

    @Test
    public void printPositiveBalance(){
        customer.setName("Luis");
        customer.setId(1);

        AccountRecord ar = new AccountRecord();
        ar.setCharge(100);

        customer.getCharges().add(ar);

        assertEquals("ID: 1 Name: Luis Balance: 100", customer.toString());

    }

    @Test
    public void printNegativeBalance(){
        AccountRecord ar = new AccountRecord();
        ar.setCharge(-10);

        customer.getCharges().add(ar);

        assertEquals("ID: 0 Name: null Balance: -10", customer.toString());

    }

}