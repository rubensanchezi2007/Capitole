package com.capitole.inditex.price.domain.mapper;

import com.capitole.inditex.domain.Error;
import com.capitole.inditex.price.domain.model.PriceError;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceErrorMapper {

    Error toDTO(PriceError priceError);

}
