package org.example.core;

public interface Monitor {
    //    设定速度
    void setSpeed_second(Integer speed_second);

    //    向Buffer中放入数据
    void putBuffer(Buffer buffer, Integer data);
}
