package com.acedemand.service;

import com.acedemand.service.spi.ICustomerService;
import domain.Customer;
import org.springframework.stereotype.Service;

/**
 * Created by Pamir on 4/22/2015.
 */
@Service("customerService")
public class CustomerService implements ICustomerService {
    @Override
    public Customer get(long id) {
        return new Customer(12,"Pamir");
    }
}
