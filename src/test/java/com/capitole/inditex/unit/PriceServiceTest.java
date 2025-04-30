package com.capitole.inditex.unit;


import com.capitole.inditex.price.domain.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceServiceTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    PriceRepository priceRepository;



}
