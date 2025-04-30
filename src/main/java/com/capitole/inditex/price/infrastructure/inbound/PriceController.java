package com.capitole.inditex.price.infrastructure.inbound;


import com.capitole.inditex.api.PriceApi;
import com.capitole.inditex.domain.GetPriceResponse;
import com.capitole.inditex.price.application.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class PriceController implements PriceApi {

    private static final Logger log = LoggerFactory.getLogger(PriceController.class);


    private final PriceService priceService;
    private final PriceControllerMapper priceControllerMapper;




    @Override
    public ResponseEntity<GetPriceResponse> getPriceByProduct(String productId, String brandId,String date ) {

        log.info("Get Price by productId {} brandId {} date {}",productId,brandId,date);

        GetPriceResponse getPriceResponse=priceControllerMapper.toDTO(priceService.getPriceByDate(Long.valueOf(productId),Integer.valueOf(brandId),LocalDateTime.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        return ResponseEntity.ok(
                getPriceResponse
        );
    }
}
