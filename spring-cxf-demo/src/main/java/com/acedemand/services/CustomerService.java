package com.acedemand.services;

import com.acedemand.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pamir on 4/22/2015.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
}
