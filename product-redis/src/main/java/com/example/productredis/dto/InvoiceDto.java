package com.example.productredis.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//@RedisHash("invoice")
public class InvoiceDto implements Serializable{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
//	
	private Long id;
	
	@JsonProperty("number")
	private String number;


}
