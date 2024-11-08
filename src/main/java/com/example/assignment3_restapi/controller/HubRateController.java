package com.example.assignment3_restapi.controller;

import com.example.assignment3_restapi.entity.HubRate;
import com.example.assignment3_restapi.entity.Order;
import com.example.assignment3_restapi.repository.HubRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hub-rates")
public class HubRateController {

    @Autowired
    private HubRateRepository hubRateRepository;

    //Retrieve all hub rates
    @GetMapping
    public List<HubRate> getAllHubRates() {
        return hubRateRepository.findAll();
    }

    // Retrieve a specific hub rate by ID
    @GetMapping("/{id}")
    public ResponseEntity<HubRate> getHubRateById(@PathVariable Long id) {
        return hubRateRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new hub rate
    @PostMapping
    public HubRate createHubRate(@RequestBody HubRate hubRate) {
        return hubRateRepository.save(hubRate);
    }

    // Update an existing hub rate
    @PutMapping("/{id}")
    public ResponseEntity<HubRate> updateHubRate(@PathVariable Long id, @RequestBody HubRate hubRateDetails) {
        return hubRateRepository.findById(id)
                .map(hubRate -> {
                    hubRate.setHubLocation(hubRateDetails.getHubLocation());
                    hubRate.setRate(hubRateDetails.getRate());
                    HubRate updatedHubRate = hubRateRepository.save(hubRate);
                    return ResponseEntity.ok(updatedHubRate);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a hub rate
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHubRate(@PathVariable Long id) {
        return hubRateRepository.findById(id)
                .map(hubRate -> {
                    hubRateRepository.delete(hubRate);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
