package com.example.productredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productredis.dto.TempDto;
import com.example.productredis.dto.InvoiceDto;
import com.example.productredis.entity.Invoice;
import com.example.productredis.service.InvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	private final InvoiceService invoiceService;
	private final RedisTemplate<String, Object> redisTemplate;
	

	
	public InvoiceController(com.example.productredis.service.InvoiceService invoiceService,
			RedisTemplate<String, Object> redisTemplate) {
		super();
		this.invoiceService = invoiceService;
		this.redisTemplate = redisTemplate;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getInvoiceById(@PathVariable long id)
	{
		return new ResponseEntity<>(invoiceService.getinvoiceById(id),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceDto invoicedto)
	{
		Invoice invoice=invoiceService.createOrUpdateInvoice(invoicedto);
		return new ResponseEntity<Invoice>(invoice, HttpStatus.CREATED);
	}

	@PostMapping("/temp")
	public ResponseEntity<?> something(@RequestBody TempDto temp){
		return invoiceService.tempData(temp);
	}
	
//	@PostMapping("/insert")
//	public ResponseEntity<String> insertData() {
//	    redisTemplate.opsForValue().set("insert", "trigger");
//	    return ResponseEntity.ok("Insert triggered");
//	}

}
