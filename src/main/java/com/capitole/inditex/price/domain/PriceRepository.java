package com.capitole.inditex.price.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findPriceByDate (Integer productId, Integer brandId, LocalDateTime date);

}
