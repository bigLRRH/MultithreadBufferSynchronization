package org.example.core.common;

public interface IndexQueue {
    void initTrue();

    void initFalse();

    Integer popIndex();

    void pushIndex(Integer index);
}
