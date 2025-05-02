package com.capitole.inditex.price.infrastructure.inbound.advice;

import com.capitole.inditex.domain.Error;
import com.capitole.inditex.price.domain.mapper.PriceErrorMapper;
import com.capitole.inditex.price.domain.model.PriceError;
import com.capitole.inditex.price.domain.model.PriceException;
import com.capitole.inditex.price.infrastructure.inbound.PriceController;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(assignableTypes = PriceController.class)
@Hidden
@AllArgsConstructor
public class PriceControllerAdvice extends ResponseEntityExceptionHandler {

    PriceErrorMapper priceErrorMapper;

    @ExceptionHandler(PriceException.class)
    public ResponseEntity<Error> priceException(final PriceException e)
    {
        return new ResponseEntity<>(priceErrorMapper.toDTO(PriceError.builder()
                .errorCode(e.getError().getErrorCode())
                .errorMessage(e.getError().getErrorMessage())
                .build()),
                HttpStatus.OK
        );


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> priceGeneralError(final Exception e) {
        return new ResponseEntity<>(
                priceErrorMapper.toDTO(PriceError.builder()
                        .errorCode(PriceError.ERROR_GATEWAY_PRICE_SERVICE.getErrorCode())
                        .errorMessage(e.getMessage())
                        .build()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
