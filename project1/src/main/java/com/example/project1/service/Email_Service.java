package com.example.project1.service;

import com.example.project1.entity.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Email_Service {

    @Autowired
    //final
    private RestTemplate restTemplate;

    //hystrix is different, after above ones
    //@HystrixCommand(fallbackMethod="sendFallbackEmail")
    public String sendEmail(EmailDetails emailDetails) {
        //EmailDetails emailDetails1=
                restTemplate.postForObject(
                "http://emailserviceprovider/email", emailDetails, EmailDetails.class);

        return "pending";
    }

    public String sendFallbackEmail(EmailDetails emailDetails){
        return "failure";
//        System.out.println("email-failure-1234");
    }

}
