package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"user","orderDetailList"})
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String orderType;

    private LocalDateTime orderAt;

    private String revAddress;

    private String revName;

    private String paymentType;

    private LocalDateTime arrivalDate;

    private Integer totalQuantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
}
