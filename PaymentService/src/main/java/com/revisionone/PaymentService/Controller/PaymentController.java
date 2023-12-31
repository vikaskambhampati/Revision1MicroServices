package com.revisionone.PaymentService.Controller;

import com.revisionone.PaymentService.Model.PaymentRequest;
import com.revisionone.PaymentService.Model.PaymentResponse;
import com.revisionone.PaymentService.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/savePayment")
    public ResponseEntity<PaymentResponse> savePayment(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse paymentResponse = paymentService.savePayment(paymentRequest);
        return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public PaymentResponse getPaymentById(@PathVariable long id){
        PaymentResponse paymentResponse = paymentService.getPaymentById(id);
        return paymentResponse;
    }

    @GetMapping(value = "/getPaymentByOrderId/{orderId}")
    public PaymentResponse getPaymentbyOrderId(@PathVariable long orderId){
        PaymentResponse paymentResponse = paymentService.getPaymentByOrderId(orderId);
        return paymentResponse;
    }
}
