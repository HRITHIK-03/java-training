package com.example.productredis.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.productredis.dto.GrnDto;
import com.example.productredis.dto.TempDto;
import com.example.productredis.entity.Grn;

@Service
public interface GrnService {
	String getgrnById(long id);
	Grn createOrUpdateGrn(GrnDto dto);
	ResponseEntity<?> tempData(TempDto temp);
}
