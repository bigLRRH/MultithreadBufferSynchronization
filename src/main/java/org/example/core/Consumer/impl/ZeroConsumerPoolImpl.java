package org.example.core.Consumer.impl;

import org.example.core.Consumer.ZeroConsumer;
import org.example.core.Consumer.ZeroConsumerPool;
import org.example.core.common.IndexQueue;
import org.example.core.common.impl.PoolImpl;

import java.util.Vector;

public class ZeroConsumerPoolImpl extends PoolImpl<ZeroConsumer> implements ZeroConsumerPool {
    public ZeroConsumerPoolImpl(Integer poolSize, Vector<Integer> speed_seconds) {
        super(poolSize, speed_seconds);
    }

    @Override
    protected void initPool() {
        for (int i = 0; i < poolSize; i++) {
            ZeroConsumer consumer = new ZeroConsumerImpl(i);
            pool.add(consumer);
        }
    }

    @Override
    protected Integer getIndex(ZeroConsumer resource) {
        return resource.getId();
    }

    @Override
    public ZeroConsumer getZeroConsumer() {
        return get();
    }

    @Override
    public void returnZeroConsumer(ZeroConsumer zeroConsumer) {
        returnResource(zeroConsumer);
    }

    @Override
    public IndexQueue getCanConsumeZeroConsumerIndexQueue() {
        return canUseIndexQueue;
    }
}
