package org.example.core.Threads.impl;

public class ThreadImpl implements org.example.core.Threads.Thread {
    protected Integer speed_second;

    @Override
    public void setSpeed_second(Integer speed_second) {
        this.speed_second = speed_second;
    }
}
