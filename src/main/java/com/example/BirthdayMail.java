package com.example;

public class BirthdayMail implements MailCode {
    @Override
    public String generate(Client client) {
        return "Happy Birthday " + client.getName() + "!";
    }
}
