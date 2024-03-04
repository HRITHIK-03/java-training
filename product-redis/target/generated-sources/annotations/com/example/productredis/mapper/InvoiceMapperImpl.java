package com.example.productredis.mapper;

import com.example.productredis.dto.InvoiceDto;
import com.example.productredis.entity.Invoice;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-04T09:56:49+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public Invoice invoiceDtoToInvoice(InvoiceDto invoicedto) {
        if ( invoicedto == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        if ( invoicedto.getId() != null ) {
            invoice.setId( invoicedto.getId() );
        }
        invoice.setNumber( invoicedto.getNumber() );

        return invoice;
    }

    @Override
    public InvoiceDto invoiceToInvoicedto(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceDto invoiceDto = new InvoiceDto();

        invoiceDto.setId( invoice.getId() );
        invoiceDto.setNumber( invoice.getNumber() );

        return invoiceDto;
    }
}
