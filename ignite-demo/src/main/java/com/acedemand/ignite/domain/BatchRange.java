package com.acedemand.ignite.domain;

import java.io.Serializable;

/**
 * Created by Pamir on 4/19/2015.
 */
public class BatchRange implements Serializable{
    private long maxValue;
    private long minValue;
    private long count;

    public BatchRange(){}

    public BatchRange(long maxValue, long minValue, long count) {
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.count = count;
    }

    public long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }

    public long getMinValue() {
        return minValue;
    }

    public void setMinValue(long minValue) {
        this.minValue = minValue;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
