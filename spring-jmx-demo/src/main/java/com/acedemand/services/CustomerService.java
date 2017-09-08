package com.acedemand.services;

import com.acedemand.domain.Customer;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service(value = "customerService")
@ManagedResource(objectName = "com.acedemand:name=com.acedemand.services.CustomerService",persistName = "customerService",description = "customer service",persistLocation = "com.acedemand")
public class CustomerService {


    private AtomicInteger count;

    public CustomerService(){
        count = new AtomicInteger();
    }

    public void insert(Customer customer){
        System.out.println("inserting customer = " + customer);
        count.incrementAndGet();
    }

    @ManagedAttribute(description = "returns customer insertion count")
    public Integer getCustomerCount(){
        return count.get();
    }
}