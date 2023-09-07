package com.revisionone.PaymentService.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {
    private long paymentId;
    private long amount;
    private long orderId;
    private Instant paymentTime;
    private String referenceNumber;
    private String status;
    private PaymentMode paymentMode;
}
