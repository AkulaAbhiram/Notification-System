package com.example.project1.repository;

import com.example.project1.entity.SenderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderRepository extends JpaRepository<SenderInfo,String> {}
