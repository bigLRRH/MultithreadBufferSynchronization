package org.example.core.common.impl;

import org.example.core.common.MyThread;

public abstract class MyThreadImpl implements MyThread {
    private Integer id;
    protected Integer speed_second;
    public MyThreadImpl(Integer id) {
        this.id = id;
    }
    @Override
    public abstract void run();

    @Override
    public void setSpeed_second(Integer speed_second) {
        this.speed_second = speed_second;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
