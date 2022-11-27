package com.example.brestaskk.controller;

import com.example.brestaskk.dto.request.AccountRequest;
import com.example.brestaskk.dto.response.AccountResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseModel<List<AccountResponse>> getAllAccount(){
        return accountService.getAllAccount();
    }

    @GetMapping("/{accountId}")
    public ResponseModel<AccountResponse> getAccountById(@PathVariable Long accountId){
        return accountService.getAccountById(accountId);
    }

    @PostMapping("/add")
    public ResponseModel<AccountResponse> addAccount(@RequestBody @Valid AccountRequest accountRequest){
        return accountService.addAccount(accountRequest);
    }
    @PatchMapping("/{accountId}")
    public ResponseModel<AccountResponse> updateAccount(@PathVariable Long accountId, @RequestBody @Valid AccountRequest accountRequest){
        return accountService.updateAccount(accountId,accountRequest);
    }
    @DeleteMapping("/{accountId}")
    public ResponseModel<AccountResponse> deleteAccount(@PathVariable Long accountId){
        return accountService.deleteAccount(accountId);
    }
}
