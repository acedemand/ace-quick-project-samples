package com.acedemand.ws;

import com.acedemand.domain.Customer;
import com.acedemand.services.CustomerService;
import com.acedemand.ws.spi.ICustomerWebService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Created by Pamir on 4/22/2015.
 */

@WebService(endpointInterface = "com.acedemand.ws.spi.ICustomerWebService")
public class CustomerWebService implements ICustomerWebService{

    @Autowired
    private CustomerService customerService;

    @Override
    public Customer findById(Long id) {
        return new Customer();
    }
}
