package com.revisionone.ProductService.Service;

import com.revisionone.ProductService.Entity.ProductEntity;
import com.revisionone.ProductService.Model.ProductRequest;
import com.revisionone.ProductService.Model.ProductResponse;
import com.revisionone.ProductService.Repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productRequest, productEntity);
        productRepository.save(productEntity);
        ProductResponse productResponse = ProductResponse.builder()
                .productId(productEntity.getProductId())
                .productName(productEntity.getProductName())
                .productPrice(productEntity.getProductPrice())
                .productQuantity(productEntity.getProductQuantity())
                .build();
        return productResponse;
    }
}
