package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //new list for unique customers
        List<Customer> customerObjects = new ArrayList<>();


        for (String[] x: customerData){
            Customer customer = new Customer();
            //save information on local variable
            int id = Integer.parseInt(x[0]);
            String name = x[1];
            int charge = Integer.parseInt(x[2]);
            String chargeDate = x[3];

            //create record information
            AccountRecord record = new AccountRecord();
            record.setCharge(charge);
            record.setChargeDate(chargeDate);
            //set id and name of customer to add to unique list
            customer.setId(id);
            customer.setName(name);

            //check if customer is already on list
            if(!customerObjects.stream().anyMatch(c -> c.getName().equals(name))){
                customerObjects.add(customer);
            }

            //add records to each corresponding customer
            for(Customer c: customerObjects){
                if(c.getId() == id){
                    c.getCharges().add(record);
                }
            }


        }


        System.out.println("Positive accounts:");
        for(Customer c: customerObjects){
            if(c.getBalance() > 0){
                System.out.println(c.toString());
            }
        }
        System.out.println("Negative accounts:");
        for(Customer c: customerObjects){
            if(c.getBalance() < 0){
                System.out.println(c.toString());
            }
        }
    }
}
