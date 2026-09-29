package com.springmicroservices.accounts.functions;

import com.springmicroservices.accounts.service.IAccountsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccountsFunctions {

    private static final Logger log = LoggerFactory.getLogger(AccountsFunctions.class);

    @Bean
    public Consumer<Long> updateCommunication(IAccountsService accountsService) {
        return accountNumber -> {
            log.info("Updating Communication status for the account number: " + accountNumber);
            // Invocazione della logica di persistenza per aggiornare il flag nel database H2
            boolean isUpdated = accountsService.updateCommunicationStatus(accountNumber);
            if (isUpdated) {
                log.info("Database successfully updated for account number: " + accountNumber);
            } else {
                log.warn("Account number not found or update failed for: " + accountNumber);
            }
        };
    }
}