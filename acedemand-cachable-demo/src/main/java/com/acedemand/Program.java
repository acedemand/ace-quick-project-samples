package com.acedemand;

import com.acedemand.services.ProductService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 6/18/2015.
 */
public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ProductService service = context.getBean(ProductService.class);
        for (int i = 0; i < 10; ++i) {
            service.findAll();
        }
    }
}
