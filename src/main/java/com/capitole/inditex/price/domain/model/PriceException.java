package com.capitole.inditex.price.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class PriceException extends RuntimeException{

    private final PriceError error;
    private final HttpStatus httpStatus;


    public static PriceException notFound()
    {
        return PriceException.builder().error(PriceError.ERROR_PRICE_NOT_FOUND).httpStatus(HttpStatus.OK).build();
    }


}
