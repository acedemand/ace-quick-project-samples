package com.acedemand.services;

import com.acedemand.cache.annotations.Cacheable;
import com.acedemand.domain.Product;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 6/18/2015.
 */
public class ProductService {

    @Cacheable(value = "product")
    public Collection<Product> findAll() {
        System.out.println("findAll = ");
        return new ArrayList<Product>();
    }
}
