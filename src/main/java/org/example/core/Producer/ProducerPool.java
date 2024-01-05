package org.example.core.Producer;

import org.example.core.common.IndexQueue;

public interface ProducerPool {
    Producer getProducer();

    void returnProducer(Producer producer);

    IndexQueue getCanProduceProducerIndexQueue();
}
