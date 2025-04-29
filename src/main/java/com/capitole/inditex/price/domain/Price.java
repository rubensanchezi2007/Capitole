package com.capitole.inditex.price.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

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
