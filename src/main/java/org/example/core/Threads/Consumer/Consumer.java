package org.example.core.Threads.Consumer;

import org.example.core.Buffer;
import org.example.core.Threads.Thread;

public interface Consumer extends Thread {
    //    设定速度
    void setSpeed_second(Integer speed_second);

    //    从Buffer中取出数据
    Integer getBuffer(Buffer buffer);
}
