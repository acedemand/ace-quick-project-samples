package com.acedemand;

import com.acedemand.domain.Customer;
import com.acedemand.services.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmxDemoProgram{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        CustomerService service = context.getBean(CustomerService.class);
        for(int i = 0; i < 1000; ++i){
            service.insert(new Customer());
            sleepUnInterruptebly(1000);
        }
    }
    static void sleepUnInterruptebly(int timeOut){
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}