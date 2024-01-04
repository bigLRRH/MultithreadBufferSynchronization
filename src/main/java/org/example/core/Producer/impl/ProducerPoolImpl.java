package org.example.core.Producer.impl;

import org.example.core.Producer.impl.ProducerImpl;
import org.example.core.common.IndexQueue;
import org.example.core.common.impl.IndexQueueImpl;
import org.example.core.Producer.Producer;

import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ProducerPoolImpl {
    private Integer producerPoolSize;
    private final Vector<Producer> producers;
    private final IndexQueue canProduceProducerIndexQueue;

    public ProducerPoolImpl(Integer producerPoolSize) {
        this.producerPoolSize = producerPoolSize;
        producers = new Vector<>(producerPoolSize);
        canProduceProducerIndexQueue = new IndexQueueImpl(producerPoolSize, true);
        for (int i = 0; i < producerPoolSize; i++) {
            producers.add(new ProducerImpl(i));
        }
    }

    public Producer getProducer() {
        Integer index = canProduceProducerIndexQueue.popIndex();
        if (index == null) return null;
        return producers.get(index);
    }

    public void returnProducer(Producer producer) {
        Integer index = producer.getId();
        if (index == null) return;
        canProduceProducerIndexQueue.pushIndex(index);
    }
}
