package com.example;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class MailSender {
    public void sendMail(MailInfo mailInfo) {
        System.out.println("Sending mail to: " + mailInfo.getClient().getName());
        System.out.println("Content: " + mailInfo.getMail());

        // MailJet implementation example
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        
        ClientOptions options = ClientOptions.builder()
                .apiKey("API_KEY")
                .apiSecretKey("API_SECRET")
                .build();
        
        client = new MailjetClient(options);
        
        request = new MailjetRequest(Emailv31.resource)
            .property(Emailv31.MESSAGES, new JSONArray()
                .put(new JSONObject()
                    .put(Emailv31.Message.FROM, new JSONObject()
                        .put("Email", "pilot@mailjet.com")
                        .put("Name", "Mailjet Pilot"))
                    .put(Emailv31.Message.TO, new JSONArray()
                        .put(new JSONObject()
                            .put("Email", "passenger1@mailjet.com")
                            .put("Name", "passenger 1")))
                    .put(Emailv31.Message.SUBJECT, "Your email flight plan!")
                    .put(Emailv31.Message.TEXTPART, mailInfo.getMail())
                    .put(Emailv31.Message.HTMLPART, "<h3>" + mailInfo.getMail() + "</h3>")));
        try {
            response = client.post(request);
            System.out.println(response.getStatus());
            System.out.println(response.getData());
        } catch (MailjetException e) {
            e.printStackTrace();
        }
    }
}
