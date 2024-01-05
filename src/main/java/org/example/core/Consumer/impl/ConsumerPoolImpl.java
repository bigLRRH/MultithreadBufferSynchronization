package org.example.core.Consumer.impl;

import org.example.core.Consumer.*;
import org.example.core.common.IndexQueue;

import java.util.Vector;


public class ConsumerPoolImpl implements ConsumerPool {
    private PositiveConsumerPool positiveConsumerPool;
    private NegativeConsumerPool negativeConsumerPool;
    private ZeroConsumerPool zeroConsumerPool;

    public ConsumerPoolImpl(Integer positiveConsumerPoolSize, Vector<Integer> positiveSpeedSeconds,
                            Integer negativeConsumerPoolSize, Vector<Integer> negativeSpeedSeconds,
                            Integer zeroConsumerPoolSize, Vector<Integer> zeroSpeedSeconds) {
        positiveConsumerPool = new PositiveConsumerPoolImpl(positiveConsumerPoolSize, positiveSpeedSeconds);
        negativeConsumerPool = new NegativeConsumerPoolImpl(negativeConsumerPoolSize, negativeSpeedSeconds);
        zeroConsumerPool = new ZeroConsumerPoolImpl(zeroConsumerPoolSize, zeroSpeedSeconds);
    }

    public PositiveConsumer getPositiveConsumer() {
        return positiveConsumerPool.getPositiveConsumer();
    }

    public NegativeConsumer getNegativeConsumer() {
        return negativeConsumerPool.getNegativeConsumer();
    }

    public ZeroConsumer getZeroConsumer() {
        return zeroConsumerPool.getZeroConsumer();
    }

    @Override
    public IndexQueue getCanConsumePositiveConsumerIndexQueue() {
        return positiveConsumerPool.getCanConsumePositiveConsumerIndexQueue();
    }

    @Override
    public IndexQueue getCanConsumeNegativeConsumerIndexQueue() {
        return negativeConsumerPool.getCanConsumeNegativeConsumerIndexQueue();
    }

    @Override
    public IndexQueue getCanConsumeZeroConsumerIndexQueue() {
        return zeroConsumerPool.getCanConsumeZeroConsumerIndexQueue();
    }
}
