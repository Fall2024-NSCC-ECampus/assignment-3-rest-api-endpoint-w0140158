package com.example.assignment3_restapi.controller;

import com.example.assignment3_restapi.entity.Company;
import com.example.assignment3_restapi.entity.Order;
import com.example.assignment3_restapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    // Retrieve all companies
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Retrieve a specific company by ID
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return companyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new company
    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    //Update an existing company
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        return companyRepository.findById(id)
                .map(company -> {
                    company.setName(companyDetails.getName());
                    company.setAddress(companyDetails.getAddress());
                    company.setContactNumber(companyDetails.getContactNumber());
                    company.setEmail(companyDetails.getEmail());
                    Company updatedCompany = companyRepository.save(company);
                    return ResponseEntity.ok(updatedCompany);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a company
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        return companyRepository.findById(id)
                .map(company -> {
                    companyRepository.delete(company);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
