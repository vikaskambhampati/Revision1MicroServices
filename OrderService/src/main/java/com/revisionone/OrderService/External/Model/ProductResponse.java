package com.revisionone.OrderService.External.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private long productId;
    private String productName;
    private long productQuantity;
    private long productPrice;
}