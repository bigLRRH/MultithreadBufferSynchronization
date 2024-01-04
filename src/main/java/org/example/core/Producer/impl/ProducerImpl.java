package org.example.core.Producer.impl;

import org.example.core.Buffer.BufferUnit;
import org.example.core.Producer.Producer;
import org.example.core.common.IndexQueue;
import org.example.core.common.impl.MyThreadImpl;

public class ProducerImpl extends MyThreadImpl implements Producer {
    private BufferUnit bufferUnit;
    private Integer data;

    public ProducerImpl(Integer id) {
        super(id);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(speed_second * 1000);
            bufferUnit.put(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void returnQueue(IndexQueue canProduceProducerIndexQueue) {
        canProduceProducerIndexQueue.pushIndex(super.getId());
    }

    public void setBufferUnit(BufferUnit bufferUnit) {
        this.bufferUnit = bufferUnit;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
