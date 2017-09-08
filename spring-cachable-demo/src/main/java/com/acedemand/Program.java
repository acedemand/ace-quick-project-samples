package com.acedemand;

import com.acedemand.service.spi.ProductService;
import com.acedemand.service.spi.TaskExecutorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by Pamir on 4/15/2015.
 */
public class Program {
    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        TaskExecutorService service = (TaskExecutorService)context.getBean(TaskExecutorService.class);

        service.run();



    }
    public static void sleepUninterapptebly(int timeout){
        try {
            Thread.currentThread().sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
