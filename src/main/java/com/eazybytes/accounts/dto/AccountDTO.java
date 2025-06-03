package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold  Account information"
)
public class AccountDTO {

    @Schema(
            name = "accountNumber",
            description = "Account number",
            example = "1234567890"
    )
    @NotEmpty(message = "Account number should not be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number should be 10 digits")
    private Long accountNumber;

    @Schema(
            name = "accountType",
            description = "Account type",
            example = "Saving"
    )
    @NotEmpty(message = "Account type should not be empty")
    private String accountType;

    @Schema(
            name = "branchAddress",
            description = "Branch address",
            example = "123 Main Street, Anytown, USA"
    )
    @NotEmpty(message = "Branch address should not be empty")
    private String branchAddress;
}
