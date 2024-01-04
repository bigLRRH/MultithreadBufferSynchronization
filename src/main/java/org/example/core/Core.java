package org.example.core;

import org.example.core.Buffer.BufferPool;
import org.example.core.Consumer.ConsumerPool;
import org.example.core.Producer.Producer;
import org.example.core.Producer.ProducerPool;

import java.util.Queue;

public class Core {
    //    缓冲池
    private BufferPool<Integer> bufferPool;
    //    生产线程池
    private ProducerPool producerPool;
    //    消费线程池
    private ConsumerPool consumerPool;
    //    输入队列
    private Queue<Integer> importQueue;
    //    生产控制线程
    private Thread produceThread;
    //    生产控制线程是否正在运行
    private Boolean isProducing = false;
    //    消费控制线程
    private Thread consumeThread;
    //    消费控制线程是否正在运行
    private Boolean isConsuming = false;
//todo
    public Core() {

        produceThread = new Thread(this::produce);
//        consumeThread = new Thread(this::consume);
    }


    public void init() {
    }

    public void start() {

    }

    public void stop() {

    }

    public void imp(Integer data) {
        importQueue.offer(data);
        if (!isProducing) produceThread.start();
    }

    private void produce() {
        while (!importQueue.isEmpty()) {
            Integer data = importQueue.poll();
            if (data == null) break;
            Producer producer;
            while ((producer = producerPool.getProducer()) == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            BufferUnit bufferUnit;
//            while ((bufferUnit = bufferPool.()) == null) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            producer.setData(data);
//            producer.setBufferUnit(bufferUnit);
//            producer.run();
        }
//        isProducing = false;
    }

    private void consume() {

    }
}
