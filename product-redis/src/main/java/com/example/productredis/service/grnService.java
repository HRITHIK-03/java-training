package com.example.productredis.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.productredis.dto.grndto;
import com.example.productredis.entity.grn;

@Service
public interface grnService {
	Optional<grn> getgrnByIdOptional(long id);
	grn createOrUpdateGrn(grndto dto);
}
