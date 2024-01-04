package org.example.core.Consumer;

import org.example.core.Buffer.BufferUnit;

public interface Consumer {
    //    从Buffer中取出数据
    Integer getBuffer(BufferUnit bufferUnit);
}
