package com.revisionone.ProductService.Service;

import com.revisionone.ProductService.Model.ProductRequest;
import com.revisionone.ProductService.Model.ProductResponse;
import org.springframework.stereotype.Service;


public interface ProductService {
    ProductResponse saveProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);

    ProductResponse reduceProductQuantity(long quantity, long productId);
}
