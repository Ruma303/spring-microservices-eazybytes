package com.springmicroservices.accounts.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
//public class EmailConfig {
//
//    @Bean
//    @Profile("qa")
//    public EmailService qaEmailService() {
//        return new EmailService("qa@eazybank.com");
//    }
//
//    @Bean
//    @Profile("prod")
//    public EmailService prodEmailService() {
//        return new EmailService("support@eazybank.com");
//    }
//}