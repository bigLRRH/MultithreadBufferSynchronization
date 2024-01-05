package org.example.core.Consumer.impl;


import org.example.core.Consumer.PositiveConsumer;
import org.example.core.Consumer.PositiveConsumerPool;
import org.example.core.common.IndexQueue;
import org.example.core.common.impl.PoolImpl;

import java.util.Vector;

public class PositiveConsumerPoolImpl extends PoolImpl<PositiveConsumer> implements PositiveConsumerPool {
    public PositiveConsumerPoolImpl(Integer poolSize, Vector<Integer> speed_seconds) {
        super(poolSize, speed_seconds);
    }

    @Override
    protected void initPool() {
        for (int i = 0; i < poolSize; i++) {
            PositiveConsumer consumer = new PositiveConsumerImpl(i);
            pool.add(consumer);
        }
    }

    @Override
    protected Integer getIndex(PositiveConsumer resource) {
        return resource.getId();
    }

    @Override
    public PositiveConsumer getPositiveConsumer() {
        return get();
    }

    @Override
    public void returnPositiveConsumer(PositiveConsumer positiveConsumer) {
        returnResource(positiveConsumer);
    }

    @Override
    public IndexQueue getCanConsumePositiveConsumerIndexQueue() {
        return canUseIndexQueue;
    }
}
