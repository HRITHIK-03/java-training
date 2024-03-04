package com.example.productredis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productredis.dto.GrnDto;
import com.example.productredis.dto.TempDto;
import com.example.productredis.entity.Grn;
import com.example.productredis.service.GrnService;

@RestController
@RequestMapping("/grn")
public class GrnController {
	private GrnService grnService;
	
	public GrnController(com.example.productredis.service.GrnService grnService) {
		this.grnService = grnService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getgrnById(@PathVariable long id)
	{
		return new ResponseEntity<>(grnService.getgrnById(id), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Grn> creategrn(@RequestBody GrnDto grndto)
	{
		Grn grn= grnService.createOrUpdateGrn(grndto);
		return new ResponseEntity<Grn>(grn, HttpStatus.CREATED);
	}
	
	@PostMapping("/temp")
	public ResponseEntity<?> something(@RequestBody TempDto temp){
		return grnService.tempData(temp);
	}


}
