package com.example.project1.controller;

import com.example.project1.entity.EmailDetails;
import com.example.project1.entity.Notification;
import com.example.project1.entity.SenderInfo;
import com.example.project1.entity.SmsDetails;
import com.example.project1.service.Email_Service;
import com.example.project1.service.Notification_Service;
import com.example.project1.service.Sms_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController {

    @Autowired
    private Notification_Service notificationService;
    //String baseUrl="http://localhost:8082/";

    @Autowired
    private Sms_Service sms_service;

    @Autowired
    private Email_Service email_service;


    @PostMapping("/notification")
    //@HystrixCommand(fallbackMethod="sendFallbackNotification")
    public Notification sendNotification(
            @RequestBody Notification notification)
    {


            EmailDetails emailDetails=new EmailDetails();
            emailDetails.setToo(notification.getReceiverEmailId());
            emailDetails.setText(notification.getContext());
            emailDetails.setSubject("URGENT");
            notification.setNotificationStatus(email_service.sendEmail(emailDetails));


            SmsDetails smsDetails = new SmsDetails();
            smsDetails.setReceiverPhone(notification.getReceiverPhone());
            smsDetails.setContext(notification.getContext());
            notification.setNotificationStatus(sms_service.sendSms(smsDetails));
        if(notification.getNotificationStatus().equals("pending"))
            notification.setNotificationStatus("success1234");

        //no need to update this notification in sender entity

        return notificationService.sendNotification(notification);
    }


    // Read or fetch operation
    @GetMapping("/notification/{txnId}")
    public String fetchNotificationStatus(@PathVariable("txnId") Long txnId)
    {
        return notificationService.fetchNotification(txnId);
    }


    // Update operation
    @PutMapping("/senderInfo/{senderId}")
    public SenderInfo updateSenderDetails(@PathVariable("senderId") String senderId,
                     @RequestBody SenderInfo senderInfo)
    {
        return notificationService.updateSenderDetails(
                senderId, senderInfo);
    }

    // Delete operation
    @DeleteMapping("/senderInfo/{senderId}")
    public String deleteDepartmentById(@PathVariable("senderId")
                                           String senderId)
    {
        return notificationService.deleteSenderDetails(
                senderId);
        //return "Deleted Successfully";
    }
}
