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

    @Override
    public ProductResponse getProductById(long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(productEntity, productResponse);
        return productResponse;
    }

    @Override
    public ProductResponse reduceProductQuantity(long quantity, long productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product Not found"));
        productEntity.setProductQuantity(productEntity.getProductQuantity()-quantity);
        productRepository.save(productEntity);
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(productEntity, productResponse);
        return productResponse;
    }
}
