package com.Project1.Productservice.controller;

import com.Project1.Productservice.DTO.ProductRequest;
import com.Project1.Productservice.DTO.ProductResponse;
import com.Project1.Productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService ProductService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
       ProductService.createProduct(productRequest);  //making endpoint to create course
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
      return  ProductService.getallProducts();
     }

}
