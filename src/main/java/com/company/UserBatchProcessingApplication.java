package com.company;

import com.company.broker.UserBroker;

public class UserBatchProcessingApplication {

    public static void main(String[] args) {
        new UserBroker("users.csv").startEngine();
    }
}
