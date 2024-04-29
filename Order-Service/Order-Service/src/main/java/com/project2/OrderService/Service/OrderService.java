package com.project2.OrderService.Service;


import com.project2.OrderService.DTO.OrderLineItemsDto;
import com.project2.OrderService.DTO.OrderRequest;
import com.project2.OrderService.Repository.OrderRepository;
import com.project2.OrderService.model.Order;
import com.project2.OrderService.model.OrderLineItems;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
//@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void PlaceOrder(OrderRequest orderRequest){ //receive order from client ro controller then controller passing req to OrderService
                                                       //and in OrderService we mapping this order req to an order obj.
                                                       //finally we saving this order into the order repo
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

      List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
               .stream()
               .map(this::mapToDto)
        .toList();

      order.setOrderLineItemsList(orderLineItems);
      orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
       return orderLineItems;
    }

}
