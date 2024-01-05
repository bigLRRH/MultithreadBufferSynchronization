package org.example.core.Producer.impl;

import org.example.core.Producer.ProducerPool;
import org.example.core.common.IndexQueue;
import org.example.core.Producer.Producer;
import org.example.core.common.impl.PoolImpl;

import java.util.Vector;

public class ProducerPoolImpl extends PoolImpl<Producer> implements ProducerPool {
    public ProducerPoolImpl(Integer producerPoolSize, Vector<Integer> speed_seconds) {
        super(producerPoolSize, speed_seconds);
    }

    protected void initPool() {
        for (int i = 0; i < poolSize; i++) {
            Producer producer = new ProducerImpl(i);
            pool.add(producer);
        }
    }

    protected Integer getIndex(Producer resource) {
        return resource.getId();
    }

    public Producer getProducer() {
        return get();
    }

    public void returnProducer(Producer producer) {
        returnResource(producer);
    }

    @Override
    public IndexQueue getCanProduceProducerIndexQueue() {
        return canUseIndexQueue;
    }
}
