package com.example.productredis.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productredis.dto.TempDto;
import com.example.productredis.dto.InvoiceDto;
import com.example.productredis.entity.Invoice;
import com.example.productredis.mapper.InvoiceMapper;
import com.example.productredis.repository.InvoiceRepository;
import com.example.productredis.service.InvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

import ch.qos.logback.core.joran.conditional.IfAction;
import lombok.Data;

@Data
@Service
@CacheConfig(cacheNames = "invoiceCache")
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private final InvoiceRepository invoiceRepository;
	
	@Autowired
	private final InvoiceMapper invoiceMapper;
	
	@Autowired
	private final RedisTemplate<String, Object> redisTemplate;
	
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper,
			RedisTemplate<String, Object> redisTemplate)
	{
		super();
		this.invoiceRepository= invoiceRepository;
		this.invoiceMapper=invoiceMapper;
		this.redisTemplate=redisTemplate;
	}
	
//	@Override
//	@Cacheable(value="invoiceCache", key ="#id")
//	@TimeToLive(unit = TimeUnit.SECONDS)
	public String getinvoiceById(long id) {
		String jsonResponse = (String) redisTemplate.opsForValue().get("invoiceCache::"+id);
		if(jsonResponse != null) {
			return jsonResponse;
		}		
		InvoiceDto getInvoiceDto = invoiceMapper.invoiceToInvoicedto(invoiceRepository.findById(id).get());
		Gson gson = new Gson();
		jsonResponse =  gson.toJson(getInvoiceDto);
		redisTemplate.opsForValue().set("invoiceCache::"+id, jsonResponse,60, TimeUnit.SECONDS);
		return jsonResponse;
	}
	

	public Object getObjectFromRedis(String key)
	{
		return redisTemplate.opsForValue().get(key);
	}


	@Override
	@Transactional
	public Invoice createOrUpdateInvoice(InvoiceDto dto) {
		Invoice invoice = invoiceMapper.invoiceDtoToInvoice(dto);
		Invoice savedInvoice=invoiceRepository.save(invoice);
		//update in redis
		
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(savedInvoice);
		
		redisTemplate.opsForValue().set("invoiceCache::"+savedInvoice.getId(), jsonResponse, 60*10 , TimeUnit.SECONDS);
		return savedInvoice;
	}
	


	@Override
	public ResponseEntity<?> tempData(TempDto temp) {
//		redisTemplate.opsForValue().set("data", temp.getDataString(),60*10,TimeUnit.SECONDS);
		Object value = redisTemplate.opsForValue().get("data");
		return new ResponseEntity<>(value,HttpStatus.CREATED);
	}

	@Override
	public Invoice insertInvoice(InvoiceDto dto) {
		String valueFromRedisString=(String) redisTemplate.opsForValue().get("insert");
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonNode=objectMapper.readTree(valueFromRedisString);
			long id= jsonNode.get("id").asLong();
			String number = jsonNode.get("number").asText();
			
			Invoice invoice = new Invoice();
			invoice.setId(id);
			invoice.setNumber(number);
			Invoice savedInvoice=invoiceRepository.save(invoice);
			
			return savedInvoice;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
