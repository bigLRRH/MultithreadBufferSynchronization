package org.example.core.Consumer;

import org.example.core.common.IndexQueue;
public interface NegativeConsumerPool {
    NegativeConsumer getNegativeConsumer();

    void returnNegativeConsumer(NegativeConsumer negativeConsumer);

    IndexQueue getCanConsumeNegativeConsumerIndexQueue();
}
