package org.example.core.Consumer;

import org.example.core.common.IndexQueue;
public interface PositiveConsumerPool {
    PositiveConsumer getPositiveConsumer();

    void returnPositiveConsumer(PositiveConsumer positiveConsumer);

    IndexQueue getCanConsumePositiveConsumerIndexQueue();
}
