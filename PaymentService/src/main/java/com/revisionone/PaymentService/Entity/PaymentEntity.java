package com.revisionone.PaymentService.Entity;

import com.revisionone.PaymentService.Model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "paymentTableRev1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;
    private long amount;
    private long orderId;
    private Instant paymentTime;
    private String referenceNumber;
    private String status;
    private PaymentMode paymentMode;
}
