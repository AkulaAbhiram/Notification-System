package com.example.messager.repository;

import com.example.messager.entity.SmsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<SmsDetails,Long> {
}
