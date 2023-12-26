package org.example.core;

import java.util.Queue;

public interface Buffer {
    //    获得Buffer中的数据个数
    Integer getBufferDataCount();

    //    获得已放入Buffer的数据个数
    Integer getDataPutCount();

    //    获得已取出的数据个数
    Integer getDataGetCount();

    //    获得平均每秒Buffer中的数据个数
    Double getAvgDataPerSecond();

    //    获得Buffer的容量
    Integer getBufferCapacity();

    //    获得Buffer的剩余容量
    Integer getBufferRemainingCapacity();

    //    获得Buffer的数据队列
    Queue<Integer> getBufferQueue();

    //    向Buffer中放入数据
    void putData(Integer data);

    //    从Buffer中取出数据
    Integer getData();
}
