package org.example.core.Buffer.impl;

import org.example.core.Buffer.BufferUnit;
import org.example.core.common.IndexQueue;
import org.example.core.common.impl.IndexQueueImpl;

import java.util.Vector;

public class BufferPoolImpl<T> implements org.example.core.Buffer.BufferPool<T> {
    //    buffer的大小
    private Integer bufferSize;
    //    buffer
    private Vector<BufferUnit<T>> bufferUnits;
    //    可produce的buffer的index
    private IndexQueue canProduceBufferIndexQueue;
    //    可consume的buffer的index
    private IndexQueue canConsumeBufferIndexQueue;

    public BufferPoolImpl(Integer bufferSize) {
        this.bufferSize = bufferSize;
        bufferUnits = new Vector<>(bufferSize);
        canProduceBufferIndexQueue = new IndexQueueImpl(bufferSize, true);
        canConsumeBufferIndexQueue = new IndexQueueImpl(bufferSize, false);
        for (int i = 0; i < bufferSize; i++) {
            bufferUnits.add(new BufferUnitImpl<>());
        }
    }

    public void produce(T data) {
        Integer index = canProduceBufferIndexQueue.popIndex();
        if (index == null) return;
        bufferUnits.get(index).put(data);
        canConsumeBufferIndexQueue.pushIndex(index);
    }

    public T consume() {
        Integer index = canConsumeBufferIndexQueue.popIndex();
        if (index == null) return null;
        T data = bufferUnits.get(index).get();
        canProduceBufferIndexQueue.pushIndex(index);
        return data;
    }
}
