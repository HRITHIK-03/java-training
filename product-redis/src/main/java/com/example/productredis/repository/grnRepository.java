package com.example.productredis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productredis.entity.grn;

@Repository
public interface grnRepository extends JpaRepository<grn, Long> {

}
