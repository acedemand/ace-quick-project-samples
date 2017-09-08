package com.acedemand.service.spi;

import com.acedemand.dao.ProductDao;
import com.acedemand.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pamir on 4/16/2015.
 */
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Product findById(int id){
        System.out.format("ProductService.findById %d \n",id);
        return productDao.findById(id);
    }
}
