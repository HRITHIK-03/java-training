package com.example.productredis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.productredis.dto.GrnDto;
import com.example.productredis.entity.Grn;



@Mapper(componentModel = "spring")
public interface GrnMapper {
//	grnMapper MAPPER = Mappers.getMapper(grnMapper.class);
//	
//	@Mapping(target = "id" , ignore = true)
//	grn map(grndto grndto);
	
	Grn grnDtoTogrn(GrnDto grndto);
	
	GrnDto grnTogrnDto(Grn grn);
	
}
