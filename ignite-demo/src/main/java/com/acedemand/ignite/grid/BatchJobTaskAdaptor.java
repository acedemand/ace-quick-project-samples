package com.acedemand.ignite.grid;

import com.acedemand.ignite.domain.BatchJob;
import com.acedemand.ignite.domain.BatchRange;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.compute.ComputeJob;
import org.apache.ignite.compute.ComputeJobAdapter;
import org.apache.ignite.compute.ComputeJobResult;
import org.apache.ignite.compute.ComputeTaskAdapter;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Created by Pamir on 4/19/2015.
 */
public class BatchJobTaskAdaptor extends ComputeTaskAdapter<BatchJob, Long>{


    /**
     * Splits the received string to words, creates a child job for each word, and sends
     * these jobs to other nodes for processing. Each such job simply prints out the received word.
     *
     * @param nodes Nodes available for this task execution.
     * @param batchJob   String to split into words for processing.
     * @param batchJob   String to split into words for processing.
     * @return Map of jobs to nodes.
     */
    @Override
    public Map<? extends ComputeJob,  ClusterNode> map(List<ClusterNode> nodes, final BatchJob batchJob) {

        Collection<BatchJob> batchJobCollection = new ArrayList<>();
        batchJobCollection.add(new BatchJob("com.acedemand.ignite.grid.BatchJobTaskAdaptor", new BatchRange(1000, 0, 200)));
        batchJobCollection.add(new BatchJob("com.acedemand.ignite.grid.BatchJobTaskAdaptor", new BatchRange(2000, 1000, 200)));
        batchJobCollection.add(new BatchJob("com.acedemand.ignite.grid.BatchJobTaskAdaptor", new BatchRange(3000, 2000, 200)));
        batchJobCollection.add(new BatchJob("com.acedemand.ignite.grid.BatchJobTaskAdaptor", new BatchRange(5000, 3000, 200)));
        batchJobCollection.add(new BatchJob("com.acedemand.ignite.grid.BatchJobTaskAdaptor", new BatchRange(6000, 4000, 200)));
        Map<ComputeJob, ClusterNode> map = new HashMap<>();

        Iterator<ClusterNode> it = nodes.iterator();

        for (final BatchJob job : batchJobCollection) {
            // If we used all nodes, restart the iterator.
            if (!it.hasNext())
                it = nodes.iterator();

            ClusterNode node = it.next();

            map.put(
                    new ComputeJobAdapter() {
                @Nullable
                @Override
                public Object execute() {
                    System.out.println();
                    System.out.println(">>> Printing '" + job.getClassName() + "' on this node from ignite job." + job.getBatchRange().getMinValue()   + " : "+ job.getBatchRange().getMaxValue());

                    // Return number of letters in the word.

                    return batchJob;
                }
            }, node);
        }

        return map;
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public Long reduce(List<ComputeJobResult> results) {


        for (ComputeJobResult res : results)
            System.out.println((((BatchJob) res.getData()).getClassName()));

        return 0L;
    }
}

