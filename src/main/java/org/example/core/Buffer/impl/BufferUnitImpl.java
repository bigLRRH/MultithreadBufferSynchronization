package org.example.core.Buffer.impl;

import org.example.core.Buffer.BufferUnit;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class BufferUnitImpl<T> implements BufferUnit<T> {
    //    数据
    T data;
    //    锁
    private final Lock lock;
    //    条件变量
    private final Condition notFull;
    private final Condition notEmpty;

    public BufferUnitImpl() {
        data = null;
        lock = new java.util.concurrent.locks.ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void put(T data) {
        try {
            lock.lock();
            while (this.data != null) notFull.await();
            this.data = data;
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T data = null;
        try {
            lock.lock();
            while (this.data == null) notEmpty.await();
            data = this.data;
            this.data = null;
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return data;
    }
}