package com.project2.OrderService.Controller;

import com.project2.OrderService.DTO.OrderRequest;
import com.project2.OrderService.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.PlaceOrder(orderRequest); //here whenever the user place order
                                               //the order will be saved in db and return the text
        return "Order Placed Sucessfully";
    }
}
