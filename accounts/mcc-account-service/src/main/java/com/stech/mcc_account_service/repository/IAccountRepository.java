package com.stech.mcc_account_service.repository;

import com.stech.mcc_account_service.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<AccountEntity, String> {

    Optional<AccountEntity> findByAccountNumberAndCustomerCu(String accountNumber, String customerCu);

}
