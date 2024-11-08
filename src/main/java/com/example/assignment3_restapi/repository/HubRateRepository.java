package com.example.assignment3_restapi.repository;

import com.example.assignment3_restapi.entity.HubRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HubRateRepository extends JpaRepository<HubRate, Long> {
    HubRate save(HubRate hubRate);
}
