package com.acedemand.ignite;

import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Pamir on 4/20/2015.
 */
public class SpringProgram {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        IgniteConfiguration configuration = context.getBean(IgniteConfiguration.class);
        Ignition.start(configuration);
    }
}
