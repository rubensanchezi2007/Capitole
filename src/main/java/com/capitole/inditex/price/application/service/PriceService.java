package com.capitole.inditex.price.application.service;

import com.capitole.inditex.price.domain.Price;
import com.capitole.inditex.price.domain.PriceException;
import com.capitole.inditex.price.domain.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Price getPriceByDate(Long productId, Integer brandId, LocalDateTime date)
    {
         List<Price> listPrices=priceRepository.findPriceByDate(productId,brandId,date);

            return listPrices
                    .stream()
                    .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                    .filter(l -> !l.isEmpty()).orElseThrow(PriceException::notFound)
                        .stream()
                            .collect(Collectors.groupingBy(
                                Price::getPriority,
                                TreeMap::new,
                                Collectors.toList()
                            ))
                            .lastEntry()
                            .getValue()
                                .stream()
                                .findFirst()
                            .get();



    }

}
