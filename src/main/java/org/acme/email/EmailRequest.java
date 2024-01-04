package org.acme.email;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailRequest {


    private String sender;
    private String dest;
    private String body;
    private String subject;

    public EmailRequest(String sender, String dest, String body, String subject) {
        this.sender = sender;
        this.dest = dest;
        this.body = body;
        this.subject = subject;
    }

    public EmailRequest() {
    }

}
