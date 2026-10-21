package com.example.project1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SenderInfo {

    @Id
    private String senderId;
    //i am assuming that the senderId is unique, how? - while registration

    private String senderName,senderEmailId,senderPhone,senderPassword;

    @OneToMany(mappedBy = "senderinfo")
    private List<Notification> notification;

}
