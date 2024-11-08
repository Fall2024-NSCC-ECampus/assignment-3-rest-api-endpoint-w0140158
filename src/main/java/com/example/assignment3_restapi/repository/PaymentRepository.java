package com.example.assignment3_restapi.repository;

import com.example.assignment3_restapi.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAll();
}
