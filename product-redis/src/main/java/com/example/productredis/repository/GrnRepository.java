package com.example.productredis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productredis.entity.Grn;

@Repository
public interface GrnRepository extends JpaRepository<Grn, Long> {

}
