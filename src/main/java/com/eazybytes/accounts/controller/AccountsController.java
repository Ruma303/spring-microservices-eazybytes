package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountConstants;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.dto.ResponseDTO;
import com.eazybytes.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private final AccountService accountService;

    @Autowired
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccount(@RequestParam String mobileNumber) {
        CustomerDTO customerDTO = accountService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccount(@RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = accountService.updateAccount(customerDTO);
        if (!isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(AccountConstants.STATUS_400, AccountConstants.MESSAGE_400));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam String mobileNumber) {
        boolean isDeleted = accountService.deleteAccount(mobileNumber);
        if (!isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(AccountConstants.STATUS_404, AccountConstants.MESSAGE_404));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        }
    }
}
