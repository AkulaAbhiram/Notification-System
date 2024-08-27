package com.example.emailserviceprovider.repository;

import com.example.emailserviceprovider.entity.EmailDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailDetails,Long> {
}
