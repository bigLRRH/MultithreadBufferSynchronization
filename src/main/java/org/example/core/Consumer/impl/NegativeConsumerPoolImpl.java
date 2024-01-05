package org.example.core.Consumer.impl;

import org.example.core.Consumer.NegativeConsumer;
import org.example.core.Consumer.NegativeConsumerPool;
import org.example.core.common.IndexQueue;
import org.example.core.common.impl.PoolImpl;

import java.util.Vector;

public class NegativeConsumerPoolImpl extends PoolImpl<NegativeConsumer> implements NegativeConsumerPool {
    public NegativeConsumerPoolImpl(Integer size, Vector<Integer> speed_seconds) {
        super(size, speed_seconds);
    }

    @Override
    protected void initPool() {
        for (int i = 0; i < poolSize; i++) {
            NegativeConsumer consumer = new NegativeConsumerImpl(i);
            consumer.setSpeed_second(speed_seconds.get(i));
            pool.add(consumer);
        }
    }

    @Override
    protected Integer getIndex(NegativeConsumer resource) {
        return resource.getId();
    }

    @Override
    public NegativeConsumer getNegativeConsumer() {
        return get();
    }

    @Override
    public void returnNegativeConsumer(NegativeConsumer negativeConsumer) {
        returnResource(negativeConsumer);
    }

    @Override
    public IndexQueue getCanConsumeNegativeConsumerIndexQueue() {
        return canUseIndexQueue;
    }
}