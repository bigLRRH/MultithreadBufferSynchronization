package org.example.core.Consumer.impl;

import org.example.core.Buffer.BufferUnit;
import org.example.core.Consumer.Consumer;
import org.example.core.common.IndexQueue;
import org.example.core.common.impl.MyThreadImpl;

public abstract class ConsumerImpl extends MyThreadImpl implements Consumer {
    private IndexQueue canConsumeConsumerQueue;
    private Integer count;

    public ConsumerImpl(Integer id) {
        super(id);
    }

    public void run() {
        try {
//            设定速度
            Thread.sleep(speed_second * 1000);
//            消费者消费数据
            count();
//            消费者消费完数据后，将自己的id放入canConsumeConsumerQueue中
            canConsumeConsumerQueue.pushIndex(super.getId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void count() {
        ++count;
    }

    public void init(IndexQueue canConsumeConsumerQueue, Integer count) {
        this.canConsumeConsumerQueue = canConsumeConsumerQueue;
        this.count = count;
    }

}
