package com.example.productredis.mapper;

import com.example.productredis.dto.GrnDto;
import com.example.productredis.entity.Grn;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-04T09:56:33+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class GrnMapperImpl implements GrnMapper {

    @Override
    public Grn grnDtoTogrn(GrnDto grndto) {
        if ( grndto == null ) {
            return null;
        }

        Grn grn = new Grn();

        grn.setNumber( grndto.getNumber() );

        return grn;
    }

    @Override
    public GrnDto grnTogrnDto(Grn grn) {
        if ( grn == null ) {
            return null;
        }

        GrnDto grnDto = new GrnDto();

        grnDto.setNumber( grn.getNumber() );

        return grnDto;
    }
}
