package com.capitole.inditex.price.application.service;

import com.capitole.inditex.price.domain.PriceRepository;
import com.capitole.inditex.price.domain.model.Price;
import com.capitole.inditex.price.domain.model.PriceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Price getPriceByDate(Long productId, Integer brandId, LocalDateTime date)
    {
        List<Price> listPrices=priceRepository.findPriceByDate(productId,brandId,date);




        return listPrices.stream().max(Comparator.comparing(Price::getPriority))
                .stream().findFirst().orElseThrow(PriceException::notFound);


         /*Commented code in case same priority compare PriceList
        return listPrices.stream()//.max(Comparator.comparing(Price::getPriority))
                .max((p1,p2)->
                { if (p1.getPriority().equals(p2.getPriority()))
                        return p1.getPriceList().compareTo(p2.getPriceList());
                    return p1.getPriority().compareTo(p2.getPriority());
                })
                .stream().findFirst().orElseThrow(PriceException::notFound);
        */
    }


}
