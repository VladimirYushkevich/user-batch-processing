package com.company.broker;

import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

public class BaseConsumer<T> {

    private BlockingQueue<T> queue;

    public BaseConsumer(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    public void consume(Consumer consumer) {
        try {
            consumer.accept(queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
