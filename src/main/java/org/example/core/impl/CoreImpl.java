package org.example.core.impl;

import org.example.core.Buffer.BufferPool;
import org.example.core.Buffer.impl.BufferPoolImpl;
import org.example.core.Consumer.Consumer;
import org.example.core.Consumer.ConsumerPool;
import org.example.core.Consumer.impl.ConsumerPoolImpl;
import org.example.core.Core;
import org.example.core.Producer.Producer;
import org.example.core.Producer.ProducerPool;
import org.example.core.Producer.impl.ProducerPoolImpl;
import org.example.entity.Result;

import java.util.Queue;

public class CoreImpl implements Core {
    //    全局实例
    private Result result;
    //    缓冲池
    private BufferPool<Integer> bufferPool;
    //    生产线程池
    private ProducerPool producerPool;
    //    消费线程池
    private ConsumerPool consumerPool;
    //    输入队列
    private Queue<Integer> importQueue;
    //    生产控制线程
    private final Thread produceControlThread;
    //    生产控制线程是否正在运行
    private Boolean isProducing = false;
    //    消费控制线程
    private final Thread consumeControlThread;
    //    消费控制线程是否正在运行
    private Boolean isConsuming = false;

    //todo
    public CoreImpl(Result result) {
        this.result = result;
        bufferPool = new BufferPoolImpl<>(result.getBuffer_count());
        producerPool = new ProducerPoolImpl(result.getP1_count(), result.getP1_put_speed());
        consumerPool = new ConsumerPoolImpl(
                result.getP2_count(), result.getP2_get_speed(),
                result.getP3_count(), result.getP3_get_speed(),
                result.getP4_count(), result.getP4_get_speed());
        importQueue = (Queue<Integer>) result.getInputContent();

        produceControlThread = new Thread(this::produce);
        consumeControlThread = new Thread(this::consume);
    }


    public void init() {

    }

    public void start() {

    }

    public void stop() {

    }

    public void input(Integer data) {
        importQueue.offer(data);
        if (!isProducing) {
            isProducing = true;
            produceControlThread.start();
        }
    }

    private void produce() {
        isProducing = true;
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
            producer.init(bufferPool, producerPool.getCanProduceProducerIndexQueue(), data);
            producer.run();
        }
        isProducing = false;
//        唤醒消费控制线程
        if (!isConsuming) {
            isConsuming = true;
            consumeControlThread.start();
        }
    }

    private void consume() {
        isConsuming = true;
        Integer data;
        while ((data = bufferPool.consume()) == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        consume(data);
        while ((data = bufferPool.consume()) != null) {
            consume(data);
        }
        isConsuming = false;
    }

    private void consume(Integer data) {
        Consumer consumer = null;
        switch ((int) Math.signum(data)) {
            case 1:
                while ((consumer = consumerPool.getPositiveConsumer()) == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                consumer.init(consumerPool.getCanConsumePositiveConsumerIndexQueue(), result.getPositive());
                break;
            case -1:
                while ((consumer = consumerPool.getNegativeConsumer()) == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                consumer.init(consumerPool.getCanConsumeNegativeConsumerIndexQueue(), result.getNegative());
                break;
            case 0:
                while ((consumer = consumerPool.getZeroConsumer()) == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                consumer.init(consumerPool.getCanConsumeZeroConsumerIndexQueue(), result.getZero());
                break;
        }
        consumer.run();
    }
}
