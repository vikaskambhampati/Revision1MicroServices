package com.revisionone.OrderService.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private long orderValue;
    private long orderQuantity;
    private String orderStatus;
    private long productId;
}
