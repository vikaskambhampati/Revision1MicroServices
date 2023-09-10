package com.revisionone.OrderService.Service;

import com.revisionone.OrderService.Model.OrderRequest;
import com.revisionone.OrderService.Model.OrderResponse;

public interface OrderService {
    OrderResponse saveOrder(OrderRequest orderRequest);

    OrderResponse getOrderById(long id);
}
