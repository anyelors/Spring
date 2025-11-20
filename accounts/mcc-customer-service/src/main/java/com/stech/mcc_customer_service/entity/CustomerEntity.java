package com.stech.mcc_customer_service.entity;

import com.stech.mcc_customer_service.dto.CustomerDTO;
import com.stech.mcc_customer_service.util.IMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "t_customer")
@Data
@NoArgsConstructor
public class CustomerEntity implements IMapper<CustomerDTO>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false, length = 60)
    private String id;

    @Column(name = "cu", length = 20, nullable = false, unique = true)
    private String cu;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "mobile", length = 9, nullable = false)
    private String mobile;

    @Override
    public CustomerDTO getDTO() {
        return CustomerDTO.builder()
                .id(id)
                .cu(cu)
                .name(name)
                .address(address)
                .email(email)
                .mobile(mobile)
                .build();
    }

    @Override
    public void setData(CustomerDTO customerDTO) {
        this.id = customerDTO.getId();
        this.cu = customerDTO.getCu();
        this.name = customerDTO.getName();
        this.address = customerDTO.getAddress();
        this.email = customerDTO.getEmail();
        this.mobile = customerDTO.getMobile();
    }
}
