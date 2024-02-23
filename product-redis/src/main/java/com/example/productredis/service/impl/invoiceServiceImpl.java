package com.example.productredis.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.productredis.dto.invoicedto;
import com.example.productredis.entity.invoice;
import com.example.productredis.mapper.invoiceMapper;
import com.example.productredis.repository.invoiceRepository;
import com.example.productredis.service.invoiceService;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Service
@CacheConfig(cacheNames = "invoiceCache")
public class invoiceServiceImpl implements invoiceService {
	private final invoiceRepository invoiceRepository;
	private final invoiceMapper invoiceMapper;
	
	public invoiceServiceImpl(invoiceRepository invoiceRepository, invoiceMapper invoiceMapper)
	{
		super();
		this.invoiceRepository= invoiceRepository;
		this.invoiceMapper=invoiceMapper;
	}
	
	@Override
	@Cacheable(value="invoicecCache", key ="#id")
	public invoicedto getinvoiceById(long id)
	{
		return invoiceMapper.invoiceToInvoicedto(invoiceRepository.findById(id).get());
	}

	@Override
//	@CacheEvict(value="invoiceCache", key = "#dto.id")
	public invoice createOrUpdateInvoice(invoicedto dto) {
//		invoice invoice=invoiceMapper.MAPPER.map(dto);
		invoice invoice = invoiceMapper.invoiceDtoToInvoice(dto);
		return invoiceRepository.save(invoice);
	}
}
