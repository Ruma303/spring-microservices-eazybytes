package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
    name = "ErrorResponse",
    description = "Schema for error response"
)
public class ErrorResponseDTO {
    @Schema(
        name = "apiPath",
        description = "API path",
        example = "/accounts"
    )
    private String apiPath;

    @Schema(
        name = "errorCode",
        description = "Error code",
        example = "400"
    )
    private HttpStatus errorCode;

    @Schema(
        name = "errorMessage",
        description = "Error message",
        example = "Account not found"
    )
    private String errorMessage;

    @Schema(
        name = "errorTime",
        description = "Error time",
        example = "2023-05-01T10:00:00"
    )
    private LocalDateTime errorTime;
}
