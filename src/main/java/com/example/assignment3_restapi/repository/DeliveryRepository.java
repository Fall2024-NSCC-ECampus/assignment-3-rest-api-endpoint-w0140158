package com.example.assignment3_restapi.repository;

import com.example.assignment3_restapi.entity.DeliveryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryDetail, Long> {

}
