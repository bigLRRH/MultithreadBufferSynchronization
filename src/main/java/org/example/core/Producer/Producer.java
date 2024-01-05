package org.example.core.Producer;

import org.example.core.Buffer.BufferPool;
import org.example.core.Buffer.BufferUnit;
import org.example.core.common.IndexQueue;
import org.example.core.common.MyThread;

public interface Producer extends MyThread {
    void init(BufferPool bufferPool, IndexQueue canProduceProducerIndexQueue, Integer data);
}