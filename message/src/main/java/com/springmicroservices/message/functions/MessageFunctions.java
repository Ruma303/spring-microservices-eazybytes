package com.springmicroservices.message.functions;

import com.springmicroservices.message.dto.AccountsMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<AccountsMessageDto, AccountsMessageDto> email() {
        return accountMsgDto -> {
            log.info("Sending email to {}", accountMsgDto.toString());
            return accountMsgDto;
        };
    }

    @Bean
    public Function<AccountsMessageDto, Long> sms() {
        return accountMsgDto -> {
            log.info("Sending sms to {}", accountMsgDto.toString());
            return accountMsgDto.accountNumber();
        };
    }
}
