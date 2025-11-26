package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MailSystemTest {
    @Test
    void testMailGeneration() {
        Client client = new Client("Alice", 25, Gender.FEMALE);
        MailInfo mailInfo = new MailInfo(client, new BirthdayMail());
        assertEquals("Happy Birthday Alice!", mailInfo.getMail());
    }
}
