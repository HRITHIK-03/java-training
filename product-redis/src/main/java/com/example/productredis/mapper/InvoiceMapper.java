package com.example.productredis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.productredis.dto.InvoiceDto;
import com.example.productredis.entity.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
//	invoiceMapper MAPPER = Mappers.getMapper(invoiceMapper.class);
//	
//	@Mapping(target = "number" , ignore = true)
//	invoice map(invoicedto invoicedto);
	
	Invoice invoiceDtoToInvoice(InvoiceDto invoicedto);
	
	InvoiceDto invoiceToInvoicedto(Invoice invoice);

}
