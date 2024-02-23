package com.example.productredis.dto;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//@RedisHash("invoice")
public class invoicedto implements Serializable{
	private Long id;
	
	@JsonProperty("number")
	private String number;
}
