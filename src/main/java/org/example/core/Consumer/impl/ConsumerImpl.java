package org.example.core.Consumer.impl;

import org.example.core.Buffer.BufferUnit;
import org.example.core.Consumer.Consumer;
import org.example.core.common.impl.MyThreadImpl;

public abstract class ConsumerImpl extends MyThreadImpl implements Consumer {

    public ConsumerImpl(Integer id) {
        super(id);
    }

    public abstract void run();

    @Override
    public Integer getBuffer(BufferUnit bufferUnit) {
        return null;
    }

}
