package io.ianlcz.rapidcargo_api.service;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import io.ianlcz.rapidcargo_api.model.Movement;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
   @Autowired
    private JavaMailSender mailSender;

    public void sendMovementEmail(Movement movement) throws MessagingException {
        String xmlContent = convertToXml(movement);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("destination@example.com");
        helper.setSubject("Movement Declaration");
        helper.setText("Please find the attached movement declaration.", false);
        helper.addAttachment("movement.xml", new ByteArrayResource(xmlContent.getBytes()));

        mailSender.send(message);
    }

    private String convertToXml(Movement movement) {
        try {
            JAXBContext context = JAXBContext.newInstance(Movement.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(movement, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error converting to XML", e);
        }
    }
}
