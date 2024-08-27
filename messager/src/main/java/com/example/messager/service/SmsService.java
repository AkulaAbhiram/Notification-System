package com.example.messager.service;

import com.example.messager.entity.SmsDetails;
import com.example.messager.repository.SmsRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Autowired
    private SmsRepository smsRepository;

    @Value("${TWILI0_ACCOUNT_SID}")
    String ACCOUNT_SID;

    @Value("${TWILI0_AUTH_TOKEN}")
    String AUTH_TOKEN;

    @Value("${TWILI0_OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;

    @PostConstruct
    private void setup(){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }


    //return type
    public void sendSms(SmsDetails smsDetails){

        Message message=Message.creator(
          new PhoneNumber(smsDetails.getReceiverPhone()),
                new PhoneNumber(OUTGOING_SMS_NUMBER),
                smsDetails.getContext()).create();

        smsRepository.save(smsDetails);
    }
}
