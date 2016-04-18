package com.company.parser;

import com.company.domain.User;
import com.company.parser.UserParser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserParserTest {

    private UserParser userParser = new UserParser();

    @Test
    public void parsersAndParseUserCorrectly() {
        User user = userParser.parseUser("1,First1,Last1,true,test1@test.com");

        assertThat(user.getId(), is(1L));
        assertThat(user.getFirstName(), is("First1"));
        assertThat(user.getLastName(), is("Last1"));
        assertThat(user.getMarked(), is(true));
        assertThat(user.getEmail(), is("test1@test.com"));

    }
}
