package com.example.productredis.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productredis.dto.grndto;
import com.example.productredis.entity.grn;
import com.example.productredis.service.grnService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RestController
@RequestMapping("/grn")
public class grnController {
	private grnService grnService;
	
	@GetMapping("/{id}")
	public ResponseEntity<grn> getgrnById(@PathVariable long id)
	{
		Optional<grn> grnOptional=grnService.getgrnByIdOptional(id);
		return grnOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<grn> creategrn(@RequestBody grndto grndto)
	{
		grn grn= grnService.createOrUpdateGrn(grndto);
		return new ResponseEntity<grn>(grn, HttpStatus.CREATED);
	}

	public grnController(com.example.productredis.service.grnService grnService) {
		super();
		this.grnService = grnService;
	}
	

}
