package com.acedemand.service.spi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

/**
 * Created by Pamir on 5/29/2015.
 */
public class TaskExecutorService {
    private TaskExecutor taskExecutor;

    @Autowired
    private ProductService service;

    public TaskExecutorService(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void run(){
        for(int i = 0; i < 25; i++) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    service.findById(1);
                }
            });
        }
    }

}
