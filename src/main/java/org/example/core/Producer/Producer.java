package org.example.core.Producer;

import org.example.core.Buffer.BufferUnit;
import org.example.core.common.IndexQueue;
import org.example.core.common.MyThread;

public interface Producer extends MyThread {
    void returnQueue(IndexQueue canProduceProducerIndexQueue);

    void setBufferUnit(BufferUnit bufferUnit);

    void setData(Integer data);
}