package org.example.core.Threads.Consumer.impl;

import org.example.core.Buffer;
import org.example.core.Threads.Consumer.Consumer;
import org.example.core.Threads.impl.ThreadImpl;

public class ConsumerImpl extends ThreadImpl implements Consumer {
    private Integer count;
    @Override
    public Integer getBuffer(Buffer buffer) {
        return null;
    }
}
