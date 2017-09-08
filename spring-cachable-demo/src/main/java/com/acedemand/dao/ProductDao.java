package com.acedemand.dao;

import com.acedemand.Program;
import com.acedemand.domain.Product;
import org.springframework.cache.annotation.Cacheable;


/**
 * Created by Pamir on 4/16/2015.
 */
public class ProductDao {



    @Cacheable(value = "product",key = "#id")
    public Product findById(int id){
        Program.sleepUninterapptebly(2000);
        System.out.println("Creating product");
        return new Product().setId(id).setName(String.format("%d_acedemand",id));
    }


}
