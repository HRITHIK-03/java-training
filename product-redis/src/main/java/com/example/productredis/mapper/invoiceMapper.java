package com.example.productredis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.productredis.dto.invoicedto;
import com.example.productredis.entity.invoice;

@Mapper(componentModel = "spring")
public interface invoiceMapper {
//	invoiceMapper MAPPER = Mappers.getMapper(invoiceMapper.class);
//	
//	@Mapping(target = "number" , ignore = true)
//	invoice map(invoicedto invoicedto);
	
	invoice invoiceDtoToInvoice(invoicedto invoicedto);
	
	invoicedto invoiceToInvoicedto(invoice invoice);

}
