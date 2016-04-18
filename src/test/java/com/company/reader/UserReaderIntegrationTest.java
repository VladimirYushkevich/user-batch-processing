package com.company.reader;

import com.company.domain.User;
import com.company.parser.UserParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class UserReaderIntegrationTest {

    @Test
    public void readsAndParseUserCorrectly() {
        List<User> users = processReader(3);

        assertThat(users.size(), is(3));
        assertThat(users.stream().map(User::getId).collect(toList()), containsInAnyOrder(1L, 2L, 3L));
        assertThat(users.stream().map(User::getMarked).collect(toList()), containsInAnyOrder(true, true, false));
    }

    @Test(expected = NoSuchElementException.class)
    public void throwsExceptionWhenFailIsEnded() {
        processReader(4);
    }

    private List<User> processReader(int count) {
        UserReader userReader = new UserReader("test.csv", new UserParser());

        List<User> users = new ArrayList();
        range(0, count).forEach(i -> {
            users.add(userReader.getNext());
        });

        return users;
    }
}
