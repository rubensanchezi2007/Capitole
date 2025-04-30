package com.capitole.inditex.price.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findPriceByDate (Long productId, Integer brandId, LocalDateTime date);

}
