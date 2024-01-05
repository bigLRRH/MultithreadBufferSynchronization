package org.example.core.Producer.impl;

import org.example.core.Buffer.BufferPool;
import org.example.core.Buffer.BufferUnit;
import org.example.core.Producer.Producer;
import org.example.core.common.IndexQueue;
import org.example.core.common.impl.MyThreadImpl;

public class ProducerImpl extends MyThreadImpl implements Producer {
    private BufferPool bufferPool;
    private IndexQueue canProduceProducerIndexQueue;
    private Integer data;

    public ProducerImpl(Integer id) {
        super(id);
    }

    @Override
    public void run() {
        try {
//            设定速度
            Thread.sleep(speed_second * 1000);
//            生产者生产数据
            bufferPool.produce(data);
//            生产者生产完数据后，将自己的id放入canProduceProducerIndexQueue中
            canProduceProducerIndexQueue.pushIndex(super.getId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(BufferPool bufferPool, IndexQueue canProduceProducerIndexQueue, Integer data) {
        this.bufferPool = bufferPool;
        this.canProduceProducerIndexQueue = canProduceProducerIndexQueue;
        this.data = data;
    }
}
