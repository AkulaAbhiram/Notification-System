package com.example.messager.controller;

import com.example.messager.entity.SmsDetails;
import com.example.messager.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//thisis different
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    SmsService smsService;

    @PostMapping("/send")
    public void sendSms(@RequestBody SmsDetails smsDetails){




        smsService.sendSms(smsDetails);
        //return "Success1234";
    }
}
