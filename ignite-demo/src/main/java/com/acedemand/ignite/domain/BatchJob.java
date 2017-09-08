package com.acedemand.ignite.domain;

import java.io.Serializable;

/**
 * Created by Pamir on 4/19/2015.
 */
public class BatchJob implements Serializable {
    private String className;
    private BatchRange batchRange;

    public BatchJob(String className, BatchRange batchRange) {
        this.className = className;
        this.batchRange = batchRange;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BatchRange getBatchRange() {
        return batchRange;
    }

    public void setBatchRange(BatchRange batchRange) {
        this.batchRange = batchRange;
    }
}
