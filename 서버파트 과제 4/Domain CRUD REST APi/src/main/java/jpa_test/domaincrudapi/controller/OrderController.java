package jpa_test.domaincrudapi.controller;

import jpa_test.domaincrudapi.Service.OrderService;
import jpa_test.domaincrudapi.domain.Order;
import jpa_test.domaincrudapi.dto.ItemDto;
import jpa_test.domaincrudapi.dto.OrderDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public String orderItem(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto.getId());
    }


    @GetMapping("/order/{id}")
    public OrderDto findItemById(@PathVariable Long id){
        return orderService.findOrderById(id);
    }

}
