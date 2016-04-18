package com.company.reader;

import com.company.domain.User;
import com.company.parser.UserParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserReader {

    private final UserParser userParser;
    private Scanner scanner;

    public UserReader(String source, UserParser userParser) {
        this.userParser = userParser;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(source).getFile());
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User getNext() {
        return userParser.parseUser(scanner.nextLine());
    }

}
