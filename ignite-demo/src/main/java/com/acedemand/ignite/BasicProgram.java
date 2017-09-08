package com.acedemand.ignite;

import com.acedemand.ignite.domain.BatchJob;
import com.acedemand.ignite.domain.BatchRange;
import com.acedemand.ignite.grid.BatchJobTaskAdaptor;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Pamir on 4/19/2015.
 */
public class BasicProgram {

    public static void main(String[] args) {
        //try (Ignite ignite = Ignition.start(ClassLoader.getSystemResource("config/example-ignite.xml").getPath())) {
        try (Ignite ignite = Ignition.start(new File("C:\\dev\\projects\\samples\\acedemand-samples\\ignite-demo\\src\\main\\resources\\config\\example-ignite.xml").getPath())) {

            IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
            System.out.println();
            System.out.println("Compute task map example started.");

            // Execute task on the cluster and wait for its completion.
            Long cnt = ignite.compute().execute(BatchJobTaskAdaptor.class, new BatchJob("com.acedemand.grid.BatchJobTasAdaptor",new BatchRange(0,1000,1000)));

            System.out.println();
            System.out.println(">>> Total number of characters in the phrase is '" + cnt + "'.");
            System.out.println(">>> Check all nodes for output (this node is also part of the cluster).");

            new Scanner(System.in).next();
        }
    }
}
