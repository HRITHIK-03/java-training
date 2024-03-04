package com.example.productredis.config;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import com.example.productredis.dto.InvoiceDto;
import com.example.productredis.entity.Invoice;
import com.example.productredis.repository.InvoiceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RedisMessageSubscriber implements MessageListener {
	private final InvoiceRepository invoiceRepository;

	public RedisMessageSubscriber() {
		this(null);
	}

	@Autowired
	public RedisMessageSubscriber(com.example.productredis.repository.InvoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}
	
	private Long extractInvoiceId(String key) {
	    String[] parts = key.split(":");
	    return Long.parseLong(parts[parts.length - 1]);
	}
	
	private void updateDatabase(Long invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);

    }

	private final ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void onMessage(Message message, byte[] pattern) {
    
		
		try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(message.getBody()))) {
	        Object obj = ois.readObject();
	        if (obj instanceof InvoiceDto) {
	            InvoiceDto invoiceDTO = (InvoiceDto) obj;
	            Long id = invoiceDTO.getId(); 
	            updateDatabase(id);
	        }
	    } catch (Exception e) {
	        // Handle deserialization error
	        System.out.println("Error processing message: " + e.getMessage());
	    }
		
 
		}
}
