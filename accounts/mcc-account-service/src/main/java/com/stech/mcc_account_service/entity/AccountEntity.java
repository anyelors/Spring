package com.stech.mcc_account_service.entity;

import com.stech.mcc_account_service.dto.AccountDTO;
import com.stech.mcc_account_service.dto.CustomerDTO;
import com.stech.mcc_account_service.util.IMapper;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_account")
@Data
@NoArgsConstructor
public class AccountEntity implements IMapper<AccountDTO>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false, length = 60)
    private String id;

    @Column(name = "account_number", length = 13, nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "account_name", length = 60, nullable = false)
    private String accountName;

    @Column(name = "account_balance", precision = 10, scale = 2)
    private BigDecimal accountBalance;

    @Column(name = "customer_cu", length = 20, nullable = false)
    private String customerCu;

    @Override
    public AccountDTO getDTO() {
        return AccountDTO.builder()
                .id(this.id)
                .accountNumber(this.accountNumber)
                .accountName(this.accountName)
                .accountBalance(this.accountBalance)
                .customer(CustomerDTO.builder()
                        .cu(this.customerCu)
                        .build())
                .build();
    }

    @Override
    public void setData(AccountDTO accountDTO) {
        this.id = accountDTO.getId();
        this.accountNumber = accountDTO.getAccountNumber();
        this.accountName = accountDTO.getAccountName();
        this.accountBalance = accountDTO.getAccountBalance();
        if (accountDTO.getCustomer() != null) {
            this.customerCu = accountDTO.getCustomer().getCu();
        }
    }
}
