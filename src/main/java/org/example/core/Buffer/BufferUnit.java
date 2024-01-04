package org.example.core.Buffer;

public interface BufferUnit<T> {
    void put(T data);

    T get();
}
