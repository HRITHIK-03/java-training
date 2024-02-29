package com.example.productredis.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.productredis.dto.tempDto;
import com.example.productredis.dto.invoicedto;
import com.example.productredis.entity.invoice;

@Service
public interface invoiceService {
	String getinvoiceById(long id);
	invoice createOrUpdateInvoice(invoicedto dto);
	ResponseEntity<?> tempData(tempDto temp);
	
}
