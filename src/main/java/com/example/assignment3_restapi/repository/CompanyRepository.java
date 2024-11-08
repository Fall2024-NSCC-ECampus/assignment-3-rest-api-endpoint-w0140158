package com.example.assignment3_restapi.repository;

import com.example.assignment3_restapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
