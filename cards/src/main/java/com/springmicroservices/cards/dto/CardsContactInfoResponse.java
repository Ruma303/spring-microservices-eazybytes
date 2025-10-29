package com.springmicroservices.cards.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CardsContactInfoResponse {
    String message;
    Map<String, String> contactDetails;
    List<String> onCallSupport;
}
