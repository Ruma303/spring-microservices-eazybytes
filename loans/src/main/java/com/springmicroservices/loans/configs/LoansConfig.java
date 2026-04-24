package com.springmicroservices.loans.configs;

import com.springmicroservices.loans.dto.LoansContactInfoDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LoansConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "loans")
    public LoansContactInfoDto loansContactInfoDto() {
        return new LoansContactInfoDto();
    }
}