package com.stech.mcc_account_service.service.interfaces;

import com.stech.mcc_account_service.dto.AccountDTO;
import com.stech.mcc_account_service.dto.DepositDTO;
import com.stech.mcc_account_service.util.ICrud;

public interface IAccountService extends ICrud<AccountDTO> {

    public AccountDTO depositInAccount(DepositDTO depositDTO);

}
