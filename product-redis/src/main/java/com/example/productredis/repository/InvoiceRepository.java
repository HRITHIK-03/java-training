package com.example.productredis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.productredis.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
//	@Query(value = "SELECT nextval('id')", nativeQuery = true)
//    Long getNextId();
}
