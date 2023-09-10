package com.revisionone.OrderService.Model;

import com.revisionone.OrderService.External.Model.PaymentResponse;
import com.revisionone.OrderService.External.Model.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private long orderId;
    private long orderValue;
    private long orderQuantity;
    private String orderStatus;
    private Instant orderDate;
    private long productId;
    private ProductResponse productResponse;
    private PaymentResponse paymentResponse;
}
