package com.springmicroservices.accounts.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AccountsContactInfoResponse {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}