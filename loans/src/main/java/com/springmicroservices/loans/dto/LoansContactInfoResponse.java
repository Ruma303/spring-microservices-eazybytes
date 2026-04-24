package com.springmicroservices.loans.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class LoansContactInfoResponse {
    String message;
    Map<String, String> contactDetails;
    List<String> onCallSupport;
}
