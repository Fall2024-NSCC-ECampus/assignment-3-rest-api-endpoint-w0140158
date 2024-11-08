package com.example.assignment3_restapi.controller;

import com.example.assignment3_restapi.entity.Company;
import com.example.assignment3_restapi.entity.DeliveryDetail;
import com.example.assignment3_restapi.entity.Order;
import com.example.assignment3_restapi.repository.CompanyRepository;
import com.example.assignment3_restapi.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/delivery-details")
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryDetailRepository;

    //  Retrieve all delivery details
    @GetMapping
    public List<DeliveryDetail> getAllDeliveryDetails() {
        return deliveryDetailRepository.findAll();
    }

    //  Retrieve a specific delivery detail by ID
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDetail> getDeliveryDetailById(@PathVariable Long id) {
        return (ResponseEntity<DeliveryDetail>) deliveryDetailRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new delivery detail
    @PostMapping
    public DeliveryDetail createDeliveryDetail(@RequestBody DeliveryDetail deliveryDetail) {
        return (DeliveryDetail) deliveryDetailRepository.save(deliveryDetail);
    }

    // Update an existing delivery detail
    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDetail> updateDeliveryDetail(@PathVariable Long id, @RequestBody DeliveryDetail deliveryDetailDetails) {
        return deliveryDetailRepository.findById(id)
                .map(deliveryDetail -> {
                    DeliveryDetail updatedDeliveryDetail = (DeliveryDetail) deliveryDetailRepository.save(deliveryDetail);
                    return ResponseEntity.ok(updatedDeliveryDetail);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    //  Delete a delivery detail
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryDetail(@PathVariable Long id) {
        return (ResponseEntity<Void>) deliveryDetailRepository.findById(id)
                .map(deliveryDetail -> {
                    deliveryDetailRepository.delete(deliveryDetail);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
