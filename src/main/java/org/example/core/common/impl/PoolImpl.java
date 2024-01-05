package org.example.core.common.impl;

import org.example.core.Producer.Producer;
import org.example.core.common.IndexQueue;
import org.example.core.common.Pool;

import java.util.Vector;

public abstract class PoolImpl<T> implements Pool<T> {
    //    资源池大小
    protected Integer poolSize;
    //    资源池
    protected Vector<T> pool;
    protected Vector<Integer> speed_seconds;
    //    可用资源索引队列
    protected IndexQueue canUseIndexQueue;

    public PoolImpl(Integer poolSize, Vector<Integer> speed_seconds) {
        this.poolSize = poolSize;
        pool = new Vector<>(poolSize);
        this.speed_seconds = speed_seconds;
        canUseIndexQueue = new IndexQueueImpl(poolSize, true);
        initPool();
    }

    protected abstract void initPool();

    protected abstract Integer getIndex(T resource);


    protected T get() {
        Integer index = canUseIndexQueue.popIndex();
        if (index == null) return null;
        return pool.get(index);
    }


    protected void returnResource(T resource) {
        Integer index = getIndex(resource);
        if (index == null) return;
        canUseIndexQueue.pushIndex(index);
    }

    protected IndexQueue getCanUseIndexQueue() {
        return canUseIndexQueue;
    }
}
