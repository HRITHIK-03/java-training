package com.example.productredis.mapper;

import com.example.productredis.dto.invoicedto;
import com.example.productredis.entity.invoice;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T17:12:39+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class invoiceMapperImpl implements invoiceMapper {

    @Override
    public invoice invoiceDtoToInvoice(invoicedto invoicedto) {
        if ( invoicedto == null ) {
            return null;
        }

        invoice invoice = new invoice();

        if ( invoicedto.getId() != null ) {
            invoice.setId( invoicedto.getId() );
        }
        invoice.setNumber( invoicedto.getNumber() );

        return invoice;
    }

    @Override
    public invoicedto invoiceToInvoicedto(invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        invoicedto invoicedto = new invoicedto();

        invoicedto.setId( invoice.getId() );
        invoicedto.setNumber( invoice.getNumber() );

        return invoicedto;
    }
}
