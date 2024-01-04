package org.example.entity;

import lombok.Data;

import java.util.Vector;
@Data
public class Result2 {
    //结果id
    private int id;



    //    Buffer 的个数
    private Integer buffer_count;
    //    各 Buffer 的容量
    private String buffer_capacity;
    //    P1的个数
    private Integer p1_count;
    //    P1 put的速度
    private String p1_put_speed;
    //    P2的个数
    private Integer p2_count;
    //    P2 get的速度
    private String p2_get_speed;
    //    P3的个数
    private Integer p3_count;
    //    P3 get的速度
    private String p3_get_speed;
    //    P4的个数
    private Integer p4_count;
    //    P4 get的速度
    private String p4_get_speed;



    //输入内容
    private String InputContent;
    private Long totalRunTime; // 总的运行时间（单位：毫秒）
    private Integer bufferDataCount; // Buffer中的数据个数
    private Integer dataPutCount; // 已放入Buffer的数据个数
    private Integer dataGetCount; // 已取出的数据个数
    private Float avgDataPs; // 平均每秒Buffer中的数据个数
    private Integer positive; // 已经取到的正数个数
    private Integer negative; // 已经取到的负数个数
    private Integer zero; // 已经取到的零的个数
    private String positiveCon; // 已经取到的正数内容
    private String negativeCon; // 已经取到的负数内容
    private String zeroCon; // 已经取到的零的内容
}
