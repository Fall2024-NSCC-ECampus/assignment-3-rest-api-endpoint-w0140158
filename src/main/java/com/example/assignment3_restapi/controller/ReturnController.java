package com.example.assignment3_restapi.controller;

import com.example.assignment3_restapi.entity.Product;
import com.example.assignment3_restapi.entity.Return;
import com.example.assignment3_restapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/returns")
public class ReturnController {

    @Autowired
    private ReturnRepository returnRepository;

    // Retrieve all returns
    @GetMapping
    public List<Return> getAllReturns() {
        return returnRepository.findAll();
    }

    // Retrieve a specific return by ID
    @GetMapping("/{id}")
    public ResponseEntity<Return> getReturnById(@PathVariable Long id) {
        return returnRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Create a new return
    @PostMapping
    public Return createReturn(@RequestBody Return returnObj) {
        return returnRepository.save(returnObj);
    }

    // Update an existing return
    @PutMapping("/{id}")
    public ResponseEntity<Return> updateReturn(@PathVariable Long id, @RequestBody Return returnDetails) {
        return returnRepository.findById(id)
                .map(returnObj -> {
                    returnObj.setOrderId(returnDetails.getOrderId());
                    returnObj.setReason(returnDetails.getReason());
                    returnObj.setReturnDate(returnDetails.getReturnDate());
                    Return updatedReturn = returnRepository.save(returnObj);
                    return ResponseEntity.ok(updatedReturn);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a return
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReturn(@PathVariable Long id) {
        return returnRepository.findById(id)
                .map(returnObj -> {
                    returnRepository.delete(returnObj);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
