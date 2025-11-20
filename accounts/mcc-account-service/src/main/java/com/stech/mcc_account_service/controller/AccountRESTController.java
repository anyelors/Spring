package com.stech.mcc_account_service.controller;

import com.stech.mcc_account_service.dto.AccountDTO;
import com.stech.mcc_account_service.dto.DepositDTO;
import com.stech.mcc_account_service.service.interfaces.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountRESTController {

    private IAccountService accountService;

    @GetMapping
    public List<AccountDTO> getAllAccounts(){
        return this.accountService.getAll();
    }

    @PostMapping
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO){
        return this.accountService.add(accountDTO);
    }

    @PutMapping("/deposit")
    public AccountDTO depositAccount(@RequestBody DepositDTO depositDTO){
        return this.accountService.depositInAccount(depositDTO);
    }
}
