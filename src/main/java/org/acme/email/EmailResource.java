package org.acme.email;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/email")
public class EmailResource {
    @Inject
    ReactiveMailer mailer;

    @POST
    @Path("/send")
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<String> sendEmail(EmailRequest emailRequest){
        Mail mail = new Mail()
                .setTo(List.of(emailRequest.getDest()))
                .setSubject(emailRequest.getSubject())
                .setHtml(emailRequest.getBody());

        return this.mailer.send(mail)
                .map(success -> "Email sent !!")
                .onFailure().recoverWithItem(failure -> "Failed to send email: " + failure.getMessage());
    }

}
