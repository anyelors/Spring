package com.stech.mcc_customer_service.service.interfaces;

import com.stech.mcc_customer_service.dto.CustomerDTO;
import com.stech.mcc_customer_service.util.ICrud;

public interface ICustomerService extends ICrud<CustomerDTO> {

    CustomerDTO getByCu(String cu);
}
