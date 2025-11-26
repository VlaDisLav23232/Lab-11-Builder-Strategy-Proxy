package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailInfo {
    private Client client;
    private MailCode mailCode;

    public String getMail() {
        return mailCode.generate(client);
    }
}
