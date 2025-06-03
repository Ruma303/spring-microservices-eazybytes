package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
    name = "Response",
    description = "Schema to hold successful response"
)
public class ResponseDTO {

    @Schema(
        name = "statusCode",
        description = "Status code",
        example = "200"
    )
    private String statusCode;

    @Schema(
        name = "statusMsg",
        description = "Status message",
        example = "Account created successfully"
    )
    private String statusMsg;
}
