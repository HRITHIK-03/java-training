package com.example.productredis.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.productredis.dto.grndto;
import com.example.productredis.entity.grn;



//@Mapper(componentModel = "spring")
public interface grnMapper {
	grnMapper MAPPER = Mappers.getMapper(grnMapper.class);
	
	@Mapping(target = "id" , ignore = true)
	grn map(grndto grndto);
	
}
