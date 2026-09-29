/*package com.springmicroservices.message.dto;
public record AccountsMessageDto(
        Long accountNumber,
        String name,
        String email,
        String mobileNumber
) {}
*/

package com.springmicroservices.message.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountsMsgDto(
        @JsonProperty("accountNumber") Long accountNumber,
        @JsonProperty("name") String name,
        @JsonProperty("email") String email,
        @JsonProperty("mobileNumber") String mobileNumber
) {}