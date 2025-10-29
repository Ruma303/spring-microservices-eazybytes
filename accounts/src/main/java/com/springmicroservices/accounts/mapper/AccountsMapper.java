package com.springmicroservices.accounts.mapper;

import com.springmicroservices.accounts.dto.AccountsContactInfoDto;
import com.springmicroservices.accounts.dto.AccountsContactInfoResponse;
import com.springmicroservices.accounts.dto.AccountsDto;
import com.springmicroservices.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsContactInfoResponse mapToAccountsContactInfoResponse(AccountsContactInfoDto accountsContactInfoDto) {
        AccountsContactInfoResponse response = new AccountsContactInfoResponse();
        response.setMessage(accountsContactInfoDto.getMessage());
        response.setContactDetails(accountsContactInfoDto.getContactDetails());
        response.setOnCallSupport(accountsContactInfoDto.getOnCallSupport());
        return response;
    }

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}