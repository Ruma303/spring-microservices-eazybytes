package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDTO {

    @Schema(
            name = "customerId",
            description = "Customer id"
    )
    private Long customerId;

    @Schema(
            name = "name",
            description = "Customer name"
    )
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Schema(
            name = "email",
            description = "Customer email"
    )
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(
            name = "mobileNumber",
            description = "Customer mobile number"
    )
    @NotEmpty(message = "Mobile number should not be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number should be 10 digits")
    private String mobileNumber;
    private AccountDTO accountDTO;
}
