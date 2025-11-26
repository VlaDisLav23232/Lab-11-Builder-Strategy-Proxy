package com.example;

public class GiftMail implements MailCode {
    @Override
    public String generate(Client client) {
        return "Black Friday! " + client.getName() + ", get your gift!";
    }
}
