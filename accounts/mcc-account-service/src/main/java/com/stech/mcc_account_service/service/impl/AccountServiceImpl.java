package com.stech.mcc_account_service.service.impl;

import com.stech.mcc_account_service.client.ICustomerRESTClient;
import com.stech.mcc_account_service.dto.AccountDTO;
import com.stech.mcc_account_service.dto.CustomerDTO;
import com.stech.mcc_account_service.dto.DepositDTO;
import com.stech.mcc_account_service.entity.AccountEntity;
import com.stech.mcc_account_service.repository.IAccountRepository;
import com.stech.mcc_account_service.service.interfaces.IAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private IAccountRepository accountRepository;
    private ICustomerRESTClient customerRESTClient;

    @Override
    public List<AccountDTO> getAll() {
        return this.accountRepository.findAll().stream().map(AccountEntity::getDTO).toList();
    }

    @Override
    public AccountDTO add(AccountDTO accountDTO) {
        ResponseEntity<CustomerDTO> responceEntityNewCustomerDTO = this.customerRESTClient.add(accountDTO.getCustomer());
        if(responceEntityNewCustomerDTO.getStatusCode().is2xxSuccessful()){
            log.info("New customer created successfully: {}", responceEntityNewCustomerDTO.getBody());
            accountDTO.setCustomer(responceEntityNewCustomerDTO.getBody());

            log.info("Adding new account: {}", accountDTO);
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setData(accountDTO);
            return this.accountRepository.save(accountEntity).getDTO();
        } else {
            log.error("Failed to create new customer. Status code: {}", responceEntityNewCustomerDTO.getStatusCode());
            return AccountDTO.builder().build();
        }


    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public void delete(AccountDTO accountDTO) {

    }

    @Override
    public AccountDTO getById(String id) {
        return null;
    }

    @Override
    public AccountDTO depositInAccount(DepositDTO depositDTO) {
        log.info("Depositing: {}", depositDTO);
        Optional<AccountEntity> optionalAccountEntity = this.accountRepository.findByAccountNumberAndCustomerCu(depositDTO.getAccountNumber(), depositDTO.getCustomerCu());
        if(optionalAccountEntity.isPresent()){
            AccountEntity accountEntity = optionalAccountEntity.get();
            accountEntity.setAccountBalance(accountEntity.getAccountBalance().add(depositDTO.getAmount()));
            return this.accountRepository.save(accountEntity).getDTO();
        }
        return AccountDTO.builder().build();
    }
}
