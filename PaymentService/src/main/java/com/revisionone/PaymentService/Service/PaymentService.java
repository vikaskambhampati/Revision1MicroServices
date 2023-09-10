package com.revisionone.PaymentService.Service;

import com.revisionone.PaymentService.Model.PaymentRequest;
import com.revisionone.PaymentService.Model.PaymentResponse;

public interface PaymentService {
    PaymentResponse savePayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentById(long id);
    PaymentResponse getPaymentByOrderId(long orderId);
}
