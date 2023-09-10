package com.revisionone.OrderService.External.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    private long amount;
    private long orderId;
    private String referenceNumber;
    private String status;
    private PaymentMode paymentMode;
}
