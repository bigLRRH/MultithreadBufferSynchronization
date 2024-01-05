package org.example.core.Consumer;

import org.example.core.Buffer.BufferUnit;
import org.example.core.common.IndexQueue;
import org.example.core.common.MyThread;

public interface Consumer extends MyThread {
    void init(IndexQueue canConsumeConsumerQueue, Integer count);

}
