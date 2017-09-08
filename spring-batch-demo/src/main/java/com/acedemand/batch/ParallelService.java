package com.acedemand.batch;

import com.acedemand.dao.TestDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Pamir on 4/14/2015.
 */

@ManagedResource()
public class ParallelService implements DisposableBean, InitializingBean {
    @Autowired
    private ThreadPoolTaskExecutor executorService;

    @Autowired
    private TestDao testDao;

    private AtomicLong processedData = new AtomicLong(0);

    @Override
    public void destroy() throws Exception {
        executorService.shutdown();
    }

    @ManagedAttribute(description = "Get Processed Data")
    public Long getProcessedData(){
        return processedData.get();
    }

    public void process(Collection<Long> idCollection) {
        Collection<Future<?>> futureCollection = new ArrayList<Future<?>>(idCollection.size());
        executorService.setQueueCapacity(idCollection.size());
        for (final Long id : idCollection) {
            futureCollection.add(executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("id = " + id);
                    processedData.incrementAndGet();
                    testDao.insert(id);
                    sleepUninterrupted(500);
                    //return null;
                }
            }));
        }
        for (Future<?> f : futureCollection){
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    private static void sleepUninterrupted(int timeout){
        try{
            Thread.sleep(timeout);
        }catch (InterruptedException ie){}
    }
}
