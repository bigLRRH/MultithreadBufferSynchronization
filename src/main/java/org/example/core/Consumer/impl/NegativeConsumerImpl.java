package org.example.core.Consumer.impl;

import org.example.core.Buffer.BufferUnit;
import org.example.core.Consumer.NegativeConsumer;

public class NegativeConsumerImpl extends ConsumerImpl implements NegativeConsumer {
    public NegativeConsumerImpl(Integer id) {
        super(id);
    }

    @Override
    public void run() {

    }

    @Override
    public Integer getBuffer(BufferUnit bufferUnit) {
        return null;
    }
}
