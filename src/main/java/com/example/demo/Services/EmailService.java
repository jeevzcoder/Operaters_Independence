package com.example.demo.Services;
import java.util.List;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    Integer a=1;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javamailsender;

    public void sendEmail(List<String> toAdd, String subject, String body) throws MessagingException {
        MimeMessage message = javamailsender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);//true indicates multipart message
        helper.setFrom(from);
        helper.setSubject(subject);
        for(String add:toAdd){
           helper.setTo(add);
        }

        //helper.setTo((InternetAddress) toAdd);
        helper.setText(body, true);
        javamailsender.send(message);
    }
}
