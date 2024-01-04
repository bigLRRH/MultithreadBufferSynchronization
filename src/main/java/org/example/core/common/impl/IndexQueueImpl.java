package org.example.core.common.impl;

import org.example.core.common.IndexQueue;

import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IndexQueueImpl implements IndexQueue {
    //    索引的个数
    private final Integer indexCount;
    //    索引队列
    private final Queue<Integer> indexQueue;
    //    该索引否在indexQueue里
    private final Vector<Boolean> isIndexContains;
    //   锁该索引是否在indexQueue里
    private final Vector<Lock> lockIsIndexContains;

    public IndexQueueImpl(Integer indexCount) {
        this.indexCount = indexCount;
        indexQueue = new LinkedBlockingDeque<>();
        isIndexContains = new Vector<>(indexCount);
        lockIsIndexContains = new Vector<>(indexCount);
        for (int i = 0; i < indexCount; i++) {
            lockIsIndexContains.add(new ReentrantLock());
        }
    }

    public IndexQueueImpl(Integer indexCount, Boolean initStatus) {
        this(indexCount);
        if (initStatus) initTrue();
        else initFalse();
    }

    //    初始化索引队列为满
    public void initTrue() {
        for (int i = 0; i < indexCount; i++) {
            indexQueue.add(i);
            isIndexContains.add(true);
        }
    }

    //    初始化索引队列为空
    public void initFalse() {
        for (int i = 0; i < indexCount; i++) {
            isIndexContains.add(false);
        }
    }

    //    获取一个可用的索引
    public Integer popIndex() {
        Integer index = indexQueue.poll();
        if (index == null) return null;
        try {
            lockIsIndexContains.get(index).lock();
            isIndexContains.set(index, false);
        } finally {
            lockIsIndexContains.get(index).unlock();
        }
        return index;
    }

    //    添加一个索引
    public void pushIndex(Integer index) {
        if (isIndexContains.get(index)) return;
        try {
            lockIsIndexContains.get(index).lock();
            isIndexContains.set(index, true);
            indexQueue.add(index);
        } finally {
            lockIsIndexContains.get(index).unlock();
        }
    }
}
