package com.stech.mcc_customer_service.repository;

import com.stech.mcc_customer_service.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, String> {

    Optional<CustomerEntity> findByCu(String cu);
}
