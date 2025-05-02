package com.capitole.inditex.price.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Builder
public class Price {

    private  Long productId;

    private  Integer brandId;

    private  Integer priceList;

    private  LocalDateTime startDate;

    private  LocalDateTime endDate;

    private  BigDecimal totalPrice;

    private Integer priority;

}
