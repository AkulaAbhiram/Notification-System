package com.example.project1.entity;
//Create a new package, entity.

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "notification_table_name")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long txnId;
    private boolean isEmail,isSms;
    private String context;
    //is senderId the foreign key here?

    @ManyToOne
    @JoinColumn(name = "senderId", referencedColumnName = "senderId")
    //but where is senderId here
    private SenderInfo senderinfo;

    private String receiverName,receiverEmailId,receiverPhone;
    private int priority;
    private String notificationStatus="pending";


}
