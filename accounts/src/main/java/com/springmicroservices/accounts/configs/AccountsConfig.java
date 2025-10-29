package com.springmicroservices.accounts.configs;

import com.springmicroservices.accounts.dto.AccountsContactInfoDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountsConfig {

    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "accounts")
    public AccountsContactInfoDto accountsContactInfoDto() {
        return new AccountsContactInfoDto();
    }
}