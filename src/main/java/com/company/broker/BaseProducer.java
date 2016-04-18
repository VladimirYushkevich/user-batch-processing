package com.company.broker;

import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class BaseProducer<T> {

    private BlockingQueue<T> queue;

    public BaseProducer(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    public void produce(Supplier<T> supplier) {
        final T msg = supplier.get();
        try {
            queue.put(msg);
            out.println("Added message: " + msg);

            // Simulate a long running process
            MILLISECONDS.sleep(900);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
