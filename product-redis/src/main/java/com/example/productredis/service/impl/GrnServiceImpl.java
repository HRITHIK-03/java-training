package com.example.productredis.service.impl;

//import static com.example.productredis.mapper.grnMapper.MAPPER;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.productredis.dto.GrnDto;
import com.example.productredis.dto.TempDto;
import com.example.productredis.entity.Grn;
import com.example.productredis.mapper.GrnMapper;
import com.example.productredis.repository.GrnRepository;
import com.example.productredis.service.GrnService;
import com.google.gson.Gson;

import lombok.Data;

@Data
@Service
@CacheConfig(cacheNames = "grnCache")
public class GrnServiceImpl implements GrnService {
	@Autowired
	private final GrnRepository grnRepository;
	
	@Autowired
	private final GrnMapper grnMapper;
	
	@Autowired
	private final RedisTemplate<String, Object> redisTemplate;
	
	public GrnServiceImpl(com.example.productredis.repository.GrnRepository grnRepository,
			com.example.productredis.mapper.GrnMapper grnMapper, RedisTemplate<String, Object> redisTemplate) {
		super();
		this.grnRepository = grnRepository;
		this.grnMapper = grnMapper;
		this.redisTemplate = redisTemplate;
	}

	@Override
	public String getgrnById(long id) {
		String jsonResponse= (String) redisTemplate.opsForValue().get("grnCache::"+id);
		if (jsonResponse != null)
			return jsonResponse;
		GrnDto getGrndto = grnMapper.grnTogrnDto(grnRepository.findById(id).get());
		Gson gson=new Gson();
		jsonResponse = gson.toJson(getGrndto);
		redisTemplate.opsForValue().set("grnCache::"+id, gson, 60*10, TimeUnit.SECONDS);
		return jsonResponse;
	}
	
	public Object getObjectFromRedis(String key)
	{
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public Grn createOrUpdateGrn(GrnDto dto) {
		Grn grn = grnMapper.grnDtoTogrn(dto);
		Grn savedGrn = grnRepository.save(grn);
		
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(savedGrn);
		
		redisTemplate.opsForValue().set("grnCache::"+savedGrn.getId(), jsonResponse , 60*10 , TimeUnit.SECONDS);
		return savedGrn;
	}

	@Override
	public ResponseEntity<?> tempData(TempDto temp) {
		Object value = redisTemplate.opsForValue().get("data");
		return new ResponseEntity<>(value,HttpStatus.CREATED);
	}

}
