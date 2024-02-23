package com.example.productredis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productredis.entity.invoice;

@Repository
public interface invoiceRepository extends JpaRepository<invoice, Long> {

}
