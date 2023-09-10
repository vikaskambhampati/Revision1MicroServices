package com.revisionone.OrderService.External.Client;

import com.revisionone.OrderService.External.Model.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productservice/product")
public interface ProductServiceFeign {
    @GetMapping(value = "/getProductById/{id}")
    ProductResponse getProductById(@PathVariable long id);

    @PutMapping(value = "/reduceProductQuantity/{quantity}")
    ProductResponse reduceProductQuantity(@PathVariable long quantity, @RequestParam(value = "productId") long productId);
}
