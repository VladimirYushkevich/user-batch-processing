package com.company.client;

import com.company.domain.User;

import static java.lang.System.out;

public class EmailClient {

    public void sendEmail(User user) {
        if (user.getMarked()) {
                out.println("Email sent to: " + user.getEmail());
        }
    }
}
