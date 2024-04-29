package com.Project1.Productservice.service;


import com.Project1.Productservice.DTO.ProductRequest;
import com.Project1.Productservice.DTO.ProductResponse;
import com.Project1.Productservice.model.Product;
import com.Project1.Productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //during compile time lambok make to us constructors
@Slf4j  //to replace placeholder to id

public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()    //to build course object
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

    productRepository.save(product); //to save course into database
    log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getallProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList(); //return it to controller
    }

    private ProductResponse mapToProductResponse(Product product) {
    return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .build();
    }

}
