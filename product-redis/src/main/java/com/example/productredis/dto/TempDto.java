package com.example.productredis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TempDto {
	@JsonProperty("data")
	String dataString;
}
