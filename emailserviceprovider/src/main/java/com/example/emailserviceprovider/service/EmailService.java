package com.example.emailserviceprovider.service;

import com.example.emailserviceprovider.entity.EmailDetails;
import com.example.emailserviceprovider.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    //read more about jms fxns

    public void sendEmail(EmailDetails emailDetails){


            SimpleMailMessage mailMsg = new SimpleMailMessage();
            mailMsg.setFrom(emailSender);
            mailMsg.setTo(emailDetails.getToo());
            mailMsg.setText(emailDetails.getText());
            mailMsg.setSubject(emailDetails.getSubject());
            javaMailSender.send(mailMsg);

        //return
                emailRepository.save(emailDetails);
    }
}
