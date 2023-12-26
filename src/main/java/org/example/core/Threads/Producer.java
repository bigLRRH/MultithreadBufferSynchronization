package org.example.core.Threads;

import org.example.core.Buffer;

public interface Producer extends Thread {
    //    设定速度
    void setSpeed_second(Integer speed_second);

    //    向Buffer中放入数据
    void putBuffer(Buffer buffer, Integer data);
}
