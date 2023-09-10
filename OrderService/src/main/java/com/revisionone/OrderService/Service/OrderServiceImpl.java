package com.revisionone.OrderService.Service;

import com.revisionone.OrderService.Entity.OrderEntity;
import com.revisionone.OrderService.External.Client.ProductServiceFeign;
import com.revisionone.OrderService.External.Model.PaymentMode;
import com.revisionone.OrderService.External.Model.PaymentRequest;
import com.revisionone.OrderService.External.Model.PaymentResponse;
import com.revisionone.OrderService.External.Model.ProductResponse;
import com.revisionone.OrderService.Model.OrderRequest;
import com.revisionone.OrderService.Model.OrderResponse;
import com.revisionone.OrderService.Repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductServiceFeign productServiceFeign;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public OrderResponse saveOrder(OrderRequest orderRequest) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderRequest, orderEntity);
        orderEntity.setOrderDate(Instant.now());
        orderRepository.save(orderEntity);

        ProductResponse productResponse = productServiceFeign.reduceProductQuantity(orderEntity.getOrderQuantity(), orderEntity.getProductId());

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .amount(orderEntity.getOrderValue())
                .status("SUCCESS")
                .orderId(orderEntity.getOrderId())
                .referenceNumber("ssssss")
                .paymentMode(PaymentMode.CASH)
                .build();
        ResponseEntity<PaymentResponse> paymentResponseResponseEntity = restTemplate.postForEntity("http://paymentservice/payment/savePayment", paymentRequest, PaymentResponse.class);
        PaymentResponse paymentResponse = paymentResponseResponseEntity.getBody();

        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(orderEntity.getOrderId())
                .orderQuantity(orderEntity.getOrderQuantity())
                .orderStatus(orderEntity.getOrderStatus())
                .orderValue(orderEntity.getOrderValue())
                .productId(orderEntity.getProductId())
                .orderDate(orderEntity.getOrderDate())
                .build();
        orderResponse.setProductResponse(productResponse);
        orderResponse.setPaymentResponse(paymentResponse);
        return orderResponse;
    }

    @Override
    public OrderResponse getOrderById(long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException());
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(orderEntity, orderResponse);

        ProductResponse productResponse = productServiceFeign.getProductById(orderEntity.getProductId());
        orderResponse.setProductResponse(productResponse);

        PaymentResponse paymentResponse = restTemplate.getForObject("http://paymentservice/payment/getPaymentByOrderId/" + orderEntity.getOrderId(), PaymentResponse.class);
        orderResponse.setPaymentResponse(paymentResponse);

        return orderResponse;
    }
}
