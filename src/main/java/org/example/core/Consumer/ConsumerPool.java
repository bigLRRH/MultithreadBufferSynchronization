package org.example.core.Consumer;

import org.example.core.common.IndexQueue;

public interface ConsumerPool {
    PositiveConsumer getPositiveConsumer();

    NegativeConsumer getNegativeConsumer();

    ZeroConsumer getZeroConsumer();

    IndexQueue getCanConsumePositiveConsumerIndexQueue();

    IndexQueue getCanConsumeNegativeConsumerIndexQueue();

    IndexQueue getCanConsumeZeroConsumerIndexQueue();
}
