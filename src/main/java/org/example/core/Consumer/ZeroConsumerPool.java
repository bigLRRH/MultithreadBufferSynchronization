package org.example.core.Consumer;

import org.example.core.common.IndexQueue;
public interface ZeroConsumerPool {
    ZeroConsumer getZeroConsumer();

    void returnZeroConsumer(ZeroConsumer zeroConsumer);

    IndexQueue getCanConsumeZeroConsumerIndexQueue();
}
