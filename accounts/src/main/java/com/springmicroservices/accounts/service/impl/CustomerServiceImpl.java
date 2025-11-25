package com.springmicroservices.accounts.service.impl;

import com.springmicroservices.accounts.dto.AccountsDto;
import com.springmicroservices.accounts.dto.CardsDto;
import com.springmicroservices.accounts.dto.CustomerDetailsDto;
import com.springmicroservices.accounts.dto.LoansDto;
import com.springmicroservices.accounts.entity.Accounts;
import com.springmicroservices.accounts.entity.Customer;
import com.springmicroservices.accounts.exception.ResourceNotFoundException;
import com.springmicroservices.accounts.mapper.AccountsMapper;
import com.springmicroservices.accounts.mapper.CustomerMapper;
import com.springmicroservices.accounts.repository.AccountsRepository;
import com.springmicroservices.accounts.repository.CustomerRepository;
import com.springmicroservices.accounts.service.ICustomerService;
import com.springmicroservices.accounts.service.client.CardsFeignClient;
import com.springmicroservices.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerID", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());

        // Creazione account
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        // Recupera le informazioni delle cards
        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardsDetails(mobileNumber, correlationId);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        // Recupera le informazioni dei loans
        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoansDetails(mobileNumber, correlationId);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
