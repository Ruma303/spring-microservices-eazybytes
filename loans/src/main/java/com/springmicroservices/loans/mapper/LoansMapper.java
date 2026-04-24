package com.springmicroservices.loans.mapper;

import com.springmicroservices.loans.dto.LoansContactInfoResponse;
import com.springmicroservices.loans.dto.LoansDto;
import com.springmicroservices.loans.entity.Loans;
import com.springmicroservices.loans.dto.LoansContactInfoDto;

public class LoansMapper {

    public static LoansContactInfoResponse mapToLoansContactInfoResponse(LoansContactInfoDto loansContactInfoDto) {
        LoansContactInfoResponse response = new LoansContactInfoResponse();
        response.setMessage(loansContactInfoDto.getMessage());
        response.setContactDetails(loansContactInfoDto.getContactDetails());
        response.setOnCallSupport(loansContactInfoDto.getOnCallSupport());
        return response;
    }

    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }
}