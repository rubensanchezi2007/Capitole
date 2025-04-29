package com.capitole.inditex.price.application.mapper;

import com.capitole.inditex.domain.Error;
import com.capitole.inditex.domain.GetPriceResponse;
import com.capitole.inditex.price.domain.Price;
import com.capitole.inditex.price.domain.PriceError;
import com.capitole.inditex.price.infrastructure.outbound.entities.PriceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceErrorMapper {

    Error toDTO(PriceError priceError);

}
