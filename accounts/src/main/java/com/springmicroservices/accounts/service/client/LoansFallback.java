package com.springmicroservices.accounts.service.client;

import com.springmicroservices.accounts.dto.LoansDto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient {

    /**
     * @param mobileNumber
     * @param correlationId
     * @return
     */
    @Override
    public ResponseEntity<LoansDto> fetchLoansDetails(String mobileNumber, String correlationId) {
        return null;
    }
}
