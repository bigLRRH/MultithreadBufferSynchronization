package org.example.entity;

import lombok.Data;

import java.util.Vector;

@Data
public class ConfigData {
    //    Buffer 的个数
    private Integer buffer_count;
    //    各 Buffer 的容量
    private Vector<Integer> buffer_capacity;
    //    P1的个数
    private Integer p1_count;
    //    P1 put的速度
    private Vector<Integer> p1_put_speed;
    //    P2的个数
    private Integer p2_count;
    //    P2 get的速度
    private Vector<Integer> p2_get_speed;
    //    P3的个数
    private Integer p3_count;
    //    P3 get的速度
    private Vector<Integer> p3_get_speed;
    //    P4的个数
    private Integer p4_count;
    //    P4 get的速度
    private Vector<Integer> p4_get_speed;

    public ConfigData(Integer buffer_count, Vector<Integer> buffer_capacity, Integer p1_count, Vector<Integer> p1_put_speed, Integer p2_count, Vector<Integer> p2_get_speed, Integer p3_count, Vector<Integer> p3_get_speed, Integer p4_count, Vector<Integer> p4_get_speed) {
        this.buffer_count = buffer_count;
        this.buffer_capacity = buffer_capacity;
        this.p1_count = p1_count;
        this.p1_put_speed = p1_put_speed;
        this.p2_count = p2_count;
        this.p2_get_speed = p2_get_speed;
        this.p3_count = p3_count;
        this.p3_get_speed = p3_get_speed;
        this.p4_count = p4_count;
        this.p4_get_speed = p4_get_speed;
    }
}
