package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.constants.AccountConstants;
import com.eazybytes.accounts.dto.AccountDTO;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.entity.Account;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyExistsException;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with number " + customer.getMobileNumber() + " already exists");
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer with number ", "mobileNumber", mobileNumber));

        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account with number ", "customerId", customer.getCustomerId().toString()));

        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDTO(customer);
        customerDTO.setAccountDTO(AccountMapper.mapToAccountDTO(account));

        return customerDTO;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        AccountDTO accountDTO = customerDTO.getAccountDTO();
        if (accountDTO != null) {
            Account account = accountRepository.findById(accountDTO.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account with number ", "accountNumber", accountDTO.getAccountNumber().toString()));

            AccountMapper.mapToAccount(accountDTO);
            account = accountRepository.save(account);

            Long customerId = account.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer with number ", "customerId", customerId.toString()));

            CustomerMapper.mapToCustomer(customerDTO);
            customer = customerRepository.save(customer);

            isUpdated = true;
        }
        return isUpdated;
    }

    private Account createNewAccount(Customer customer) {
        Account account = new Account();
        account.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = (long) (Math.random() * 1000000000);
        account.setAccountNumber(randomAccountNumber);
        account.setAccountType(AccountConstants.SAVING);
        account.setBranchAddress(AccountConstants.ADDRESS);
        account.setCreatedAt(LocalDateTime.now());
        account.setCreatedBy("Anonymous");
        return account;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
      Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
              () -> new ResourceNotFoundException("Customer with number ", "mobileNumber", mobileNumber));
      accountRepository.deleteByCustomerId(customer.getCustomerId());
      customerRepository.deleteById(customer.getCustomerId());
      return true;
    }

}
