package com.example.myrh.helper;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Email {

    final JavaMailSender javaMailSender;

    // method to send email
    public void sendEmail(String toAddress, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toAddress);
        msg.setSubject(subject);
        msg.setText(body);

        javaMailSender.send(msg);
    }

}
