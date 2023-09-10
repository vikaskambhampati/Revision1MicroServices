package com.revisionone.ProductService.Controller;

import com.revisionone.ProductService.Model.ProductRequest;
import com.revisionone.ProductService.Model.ProductResponse;
import com.revisionone.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping(value = "/saveProduct")
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.saveProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getProductById/{id}")
    public ProductResponse getProductById(@PathVariable long id){
        ProductResponse productResponse = productService.getProductById(id);
        return productResponse;
    }

    @PutMapping(value = "/reduceProductQuantity/{quantity}")
    public ProductResponse reduceProductQuantity(@PathVariable long quantity, @RequestParam(value = "productId") long productId){
        ProductResponse productResponse = productService.reduceProductQuantity(quantity, productId);
        return productResponse;
    }
}
