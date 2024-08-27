package com.example.emailserviceprovider.controller;

import com.example.emailserviceprovider.entity.EmailDetails;
import com.example.emailserviceprovider.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public void sendEmail(@RequestBody EmailDetails emailDetails){

        //RestTemplate restTemplate=new RestTemplate();
        //Notification notification=restTemplate.getForObject(
        //        "http://localhost:8081/notification", Notification.class);



        //return
        emailService.sendEmail(emailDetails);

        //ResponseEntity()
        //for returning json object instance
    }

}
