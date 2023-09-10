package com.revisionone.PaymentService.Service;

import com.revisionone.PaymentService.Entity.PaymentEntity;
import com.revisionone.PaymentService.Model.PaymentRequest;
import com.revisionone.PaymentService.Model.PaymentResponse;
import com.revisionone.PaymentService.Repository.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public PaymentResponse savePayment(PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(paymentRequest, paymentEntity);
        paymentEntity.setPaymentTime(Instant.now());
        paymentRepository.save(paymentEntity);
        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentId(paymentEntity.getPaymentId())
                .amount(paymentEntity.getAmount())
                .orderId(paymentEntity.getOrderId())
                .status(paymentEntity.getStatus())
                .referenceNumber(paymentEntity.getReferenceNumber())
                .paymentTime(paymentEntity.getPaymentTime())
                .paymentMode(paymentEntity.getPaymentMode())
                .build();
        return paymentResponse;
    }

    @Override
    public PaymentResponse getPaymentById(long id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment Not found"));
        PaymentResponse paymentResponse = new PaymentResponse();
        BeanUtils.copyProperties(paymentEntity, paymentResponse);
        return paymentResponse;
    }

    @Override
    public PaymentResponse getPaymentByOrderId(long orderId) {
        PaymentEntity paymentEntity = paymentRepository.findByOrderId(orderId);
        PaymentResponse paymentResponse = new PaymentResponse();
        BeanUtils.copyProperties(paymentEntity, paymentResponse);
        return paymentResponse;
    }
}
