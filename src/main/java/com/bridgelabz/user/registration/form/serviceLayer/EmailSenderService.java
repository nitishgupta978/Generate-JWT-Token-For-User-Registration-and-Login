package com.bridgelabz.user.registration.form.serviceLayer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String toEmail,String subject,String body){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("nlg012001@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        log.error("Email send by SuccessFully");
        javaMailSender.send(mailMessage);
    }
}
