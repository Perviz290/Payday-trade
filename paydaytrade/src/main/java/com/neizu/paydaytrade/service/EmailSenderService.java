package com.neizu.paydaytrade.service;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService {


    private final JavaMailSender javaMailSender;



    public void sendEmail(String toEmail,String subject,String message){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        simpleMailMessage.setFrom("");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText(message);
        simpleMailMessage.setSubject(subject);



    }



}