package org.example.core.Producer;

public interface ProducerPool {
    Producer getProducer();

    void returnProducer(Producer producer);
}
