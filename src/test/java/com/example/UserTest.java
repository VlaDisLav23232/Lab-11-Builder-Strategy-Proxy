package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testUserBuilder() {
        User user = User.builder()
                .name("John")
                .age(30)
                .gender(Gender.MALE)
                .occupation("Developer")
                .occupation("Teacher")
                .build();

        assertEquals("John", user.getName());
        assertEquals(30, user.getAge());
        assertEquals(Gender.MALE, user.getGender());
        assertEquals(2, user.getOccupations().size());
        assertTrue(user.getOccupations().contains("Developer"));
    }
}
