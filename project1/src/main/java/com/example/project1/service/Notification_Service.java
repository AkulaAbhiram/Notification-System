package com.example.project1.service;

import com.example.project1.entity.Notification;
import com.example.project1.entity.SenderInfo;
import com.example.project1.repository.NotificationRepository;
import com.example.project1.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class Notification_Service {


    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private SenderRepository senderRepository;



    //to send the notifications by senders
    public Notification sendNotification(Notification notification){
        return notificationRepository.save(notification);
    }

    //to fetch the notification status rn
    public String fetchNotification(Long txnId){

        Optional <Notification> notify =notificationRepository.findById(txnId);
        if(notify.isPresent()) {
            Notification notification = notify.get();
            return notification.getNotificationStatus();

        }
        return "invalid txn-id";
    }

    //for sender to update his contact info stored with us
    public SenderInfo updateSenderDetails(String senderId, SenderInfo newSenderInfo){

        Optional<SenderInfo> sender=senderRepository.findById(senderId);
        // is @valid an optional fxn for all this?
//        if(!(sender.isPresent())) {
//            return null;
//        }

        SenderInfo oldSenderInfo =sender.get();
        //verifying new name
        if (Objects.nonNull(newSenderInfo.getSenderName())
                && !"".equalsIgnoreCase(
                newSenderInfo.getSenderName())) {
            oldSenderInfo.setSenderName(
                    newSenderInfo.getSenderName());
        }

        //verifying new password
        if (Objects.nonNull(newSenderInfo.getSenderPassword())
                && !"".equalsIgnoreCase(
                newSenderInfo.getSenderPassword())) {
            oldSenderInfo.setSenderPassword(
                    newSenderInfo.getSenderPassword());
        }

        //verifying new phone
        if (Objects.nonNull(newSenderInfo.getSenderPhone())
                && !"".equalsIgnoreCase(
                newSenderInfo.getSenderPhone())) {
            oldSenderInfo.setSenderPhone(
                    newSenderInfo.getSenderPhone());
        }

        //verifying new email
        if (Objects.nonNull(newSenderInfo.getSenderEmailId())
                && !"".equalsIgnoreCase(
                newSenderInfo.getSenderEmailId())) {
            oldSenderInfo.setSenderEmailId(
                    newSenderInfo.getSenderEmailId());
        }

        //check if returns an exception if db not accessable?
        return senderRepository.save(oldSenderInfo);
    }

    //to delete already existing sender info
    public String deleteSenderDetails(String senderId){

        if(senderRepository.findById(senderId).isPresent()) {
            senderRepository.deleteById(senderId);
            return "Success";
        }
        return "no record existence in this universe";
    }

    //for sender to retrieve his previously sent notifications
    // In your service or repository layer
//    public List<Notification> getNotificationsBySenderId(String senderId) {
//        return notificationRepository.findBySender_SenderId(senderId);
//    }


}
