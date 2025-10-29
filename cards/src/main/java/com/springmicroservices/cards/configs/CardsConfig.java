package com.springmicroservices.cards.configs;

import com.springmicroservices.cards.dto.CardsContactInfoDto;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CardsConfig {

    @Bean
    @Primary
    @RefreshScope
    public CardsContactInfoDto cardsContactInfoDto(CardsContactInfoDto cardsContactInfoDto) {
        return new CardsContactInfoDto();
    }
}