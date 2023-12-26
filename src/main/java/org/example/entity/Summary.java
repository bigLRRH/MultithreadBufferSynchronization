package org.example.entity;

import lombok.Data;
import java.util.Vector;
@Data
public class Summary {
    private Long totalRunTime; // 总的运行时间（单位：毫秒）
    private Integer bufferDataCount; // Buffer中的数据个数
    private Integer dataPutCount; // 已放入Buffer的数据个数
    private Integer dataGetCount; // 已取出的数据个数
    private Double avgDataPerSecond; // 平均每秒Buffer中的数据个数
    private Integer positiveCount; // 已经取到的正数个数
    private Integer negativeCount; // 已经取到的负数个数
    private Integer zeroCount; // 已经取到的零的个数
    private Vector<Integer> positiveContent; // 已经取到的正数内容
    private Vector<Integer> negativeContent; // 已经取到的负数内容
    private Vector<Integer> zeroContent; // 已经取到的零的内容
}
