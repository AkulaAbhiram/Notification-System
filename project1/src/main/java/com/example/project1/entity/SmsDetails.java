package com.example.project1.entity;

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

@Table
public class SmsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long smsId;

    private String receiverPhone,context;


}
