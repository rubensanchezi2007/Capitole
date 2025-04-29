package com.capitole.inditex.price.application.advice;

import com.capitole.inditex.domain.Error;
import com.capitole.inditex.price.application.mapper.PriceErrorMapper;
import com.capitole.inditex.price.domain.PriceError;
import com.capitole.inditex.price.domain.PriceException;
import com.capitole.inditex.price.infrastructure.inbound.PriceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(assignableTypes = PriceController.class)
public class PriceControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(PriceControllerAdvice.class);

    @Autowired
    PriceErrorMapper priceErrorMapper;

    @ExceptionHandler(PriceException.class)
    public ResponseEntity<Error> priceException(final PriceException e)
    {
        log.error("Call to Price service failed with errorCode {}, errorMessage {}",e.getError().getErrorCode(),e.getMessage());


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
