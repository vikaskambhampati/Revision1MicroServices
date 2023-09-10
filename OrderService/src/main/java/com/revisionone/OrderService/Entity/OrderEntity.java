package com.revisionone.OrderService.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ordertablerev1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private long orderValue;
    private Instant orderDate;
    private long orderQuantity;
    private String orderStatus;
    private long productId;
}
