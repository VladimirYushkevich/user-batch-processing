package com.company.broker;

import com.company.domain.User;
import com.company.client.EmailClient;
import com.company.parser.UserParser;
import com.company.reader.UserReader;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.lang.System.exit;
import static java.lang.System.out;

public class UserBroker {

    private final BlockingQueue<User> queue = new ArrayBlockingQueue<>(10);

    private UserReader userReader;
    private EmailClient emailClient;

    public UserBroker(String source) {
        this.userReader = new UserReader(source, new UserParser());
        this.emailClient = new EmailClient();
    }

    public void startEngine() {
        startProducer();
        startConsumer();
    }

    private void startProducer() {
        final BaseProducer<User> baseProducer = new BaseProducer<>(queue);
        final Supplier<User> supplier = () -> userReader.getNext();
        out.println("------------Producer started------------");
        new Thread(() -> {
            while (true) {
                try {
                    baseProducer.produce(supplier);
                } catch (NoSuchElementException e) {
                    out.println("------------Producer terminated------------");
                    exit(0);
                }
            }
        }).start();
    }

    private void startConsumer() {
        final BaseConsumer<User> baseConsumer = new BaseConsumer<>(queue);
        final Consumer<User> consumer = (u) -> emailClient.sendEmail(u);
        new Thread(() -> {
            while (true) {
                baseConsumer.consume(consumer);
            }
        }).start();
    }
}
