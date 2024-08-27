package com.example.project1.service;

import com.example.project1.entity.SmsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Sms_Service {


    @Autowired
    private RestTemplate restTemplate;


    //@HystrixCommand(fallbackMethod="sendFallbackSms")
    public String sendSms(SmsDetails smsDetails) {
        //SmsDetails smsDetails1=
                restTemplate.postForObject(
                "http://messager/sms/send", smsDetails, SmsDetails.class);
        return "pending";
    }

    public String sendFallbackSms(SmsDetails smsDetails){
        return "failure";
    }



}
