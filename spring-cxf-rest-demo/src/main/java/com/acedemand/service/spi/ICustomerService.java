package com.acedemand.service.spi;

import domain.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by Pamir on 4/22/2015.
 */
@Path("/customerService")
@Produces("application/json")
public interface ICustomerService {
    @GET
    @Path("/{id}")
    public Customer get(@PathParam("id") long id);
}
