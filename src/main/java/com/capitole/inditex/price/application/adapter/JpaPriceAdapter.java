package com.capitole.inditex.price.application.adapter;

import com.capitole.inditex.price.application.mapper.PriceMapper;
import com.capitole.inditex.price.domain.Price;
import com.capitole.inditex.price.domain.PriceRepository;
import com.capitole.inditex.price.infrastructure.outbound.repository.PriceJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaPriceAdapter implements PriceRepository {
    private final PriceJPARepository priceJPARepository;
    private final PriceMapper priceMapper;


    @Override
    public List<Price> findPriceByDate(Long productId, Integer brandId, LocalDateTime date) {
        return priceMapper.map(priceJPARepository.findPriceByDate(productId,brandId,date));
    }
}
