package com.revisionone.OrderService.Controller;

import com.revisionone.OrderService.Model.OrderRequest;
import com.revisionone.OrderService.Model.OrderResponse;
import com.revisionone.OrderService.Service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/saveOrder")
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.saveOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getOrderById/{id}")
    public OrderResponse getOrderById(@PathVariable long id){
        OrderResponse orderResponse = orderService.getOrderById(id);
        return orderResponse;
    }
}
