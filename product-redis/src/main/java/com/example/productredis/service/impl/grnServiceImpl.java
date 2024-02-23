package com.example.productredis.service.impl;

//import static com.example.productredis.mapper.grnMapper.MAPPER;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.productredis.dto.grndto;
import com.example.productredis.entity.grn;
import com.example.productredis.mapper.grnMapper;
import com.example.productredis.repository.grnRepository;
import com.example.productredis.service.grnService;

import lombok.Data;


@Service
@CacheConfig(cacheNames = "grnCache")
public class grnServiceImpl implements grnService {
	private final grnRepository grnRepository ;
	
	//private final grnMapper grnMapper;
	
	@Autowired
	public grnServiceImpl(grnRepository grnRepository)
	{
		this.grnRepository=grnRepository;
		//this.grnMapper=grnMapper;
	}

	@Override
	@Cacheable(value ="grnCache", key = "#id")
	public Optional<grn> getgrnByIdOptional(long id) {
		return grnRepository.findById(id);
	}

	@Override
	@CacheEvict(value="grnCache", key= "#dto.id")
	public grn createOrUpdateGrn(grndto dto) {
		grn grn=grnMapper.MAPPER.map(dto);
		return grnRepository.save(grn);
	}

}
