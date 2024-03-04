package com.example.productredis.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.productredis.dto.TempDto;
import com.example.productredis.dto.InvoiceDto;
import com.example.productredis.entity.Invoice;

@Service
public interface InvoiceService {
	String getinvoiceById(long id);
	Invoice createOrUpdateInvoice(InvoiceDto dto);
	Invoice insertInvoice(InvoiceDto dto);
	ResponseEntity<?> tempData(TempDto temp);
	
}
