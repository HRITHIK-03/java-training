package com.example.productredis.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productredis.dto.invoicedto;
import com.example.productredis.entity.invoice;
import com.example.productredis.service.invoiceService;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/invoice")
public class invoiceController {
	private final invoiceService invoiceService;
	
	@Autowired
	public invoiceController(invoiceService invoiceService)
	{
		this.invoiceService=invoiceService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getInvoiceById(@PathVariable long id)
	{
//		Optional<invoice> invoiceOptional=invoiceService.getinvoiceById(id);
//		return invoiceOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
		return new ResponseEntity<>(invoiceService.getinvoiceById(id),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<invoice> createInvoice(@RequestBody invoicedto invoicedto)
	{
		invoice invoice=invoiceService.createOrUpdateInvoice(invoicedto);
		return new ResponseEntity<invoice>(invoice, HttpStatus.CREATED);
	}
	
}
