package com.acedemand.ws.spi;

import com.acedemand.domain.Customer;

import javax.jws.WebService;

/**
 * Created by Pamir on 4/22/2015.
 */

@WebService(name = "CustomerWebService")
public interface ICustomerWebService {
    Customer findById(Long id);

}
