package com.example.productredis.config;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import com.example.productredis.entity.invoice;
import com.example.productredis.repository.invoiceRepository;

@Component
public class redisMessageSubscriber implements MessageListener {
	private final invoiceRepository invoiceRepository;

	public redisMessageSubscriber() {
		this(null);
	}

	@Autowired
	public redisMessageSubscriber(com.example.productredis.repository.invoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}
	
	private Long extractInvoiceId(String key) {
	    String[] parts = key.split(":");
	    return Long.parseLong(parts[parts.length - 1]);
	}
	
	private void updateDatabase(Long invoiceId) {
        invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice != null) {
            // Update the invoice entity or perform any other action
            // For demonstration purposes, let's just print the invoice
            System.out.println("Updating invoice with ID: " + invoiceId);
        } else {
            System.out.println("Invoice with ID " + invoiceId + " not found in the database");
        }
    }

	
	public void onMessage(Message message , byte[] pattern)
	{
		String key = new String(message.getBody(), StandardCharsets.UTF_8);
		Long invoiceId = extractInvoiceId(key);
		updateDatabase(invoiceId);
	}
	
	

}
