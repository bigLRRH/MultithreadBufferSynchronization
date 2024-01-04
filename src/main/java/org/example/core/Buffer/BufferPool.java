package org.example.core.Buffer;

public interface BufferPool<T> {
    void produce(T data);

    T consume();
}
