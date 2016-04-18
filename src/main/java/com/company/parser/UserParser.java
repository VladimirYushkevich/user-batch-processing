package com.company.parser;

import com.company.domain.User;

public class UserParser {

    private static final String SEPARATOR = ",";

    public User parseUser(String input) {
        String[] parts = input.split(SEPARATOR);

        User user = new User();
        user.setId(Long.valueOf(parts[0]));
        user.setFirstName(parts[1]);
        user.setLastName(parts[2]);
        user.setMarked(Boolean.valueOf(parts[3]));
        user.setEmail(parts[4]);

        return user;
    }
}
