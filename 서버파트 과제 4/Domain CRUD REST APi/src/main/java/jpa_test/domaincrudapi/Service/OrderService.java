package jpa_test.domaincrudapi.Service;

import jpa_test.domaincrudapi.domain.Item;
import jpa_test.domaincrudapi.domain.Order;
import jpa_test.domaincrudapi.dto.ItemDto;
import jpa_test.domaincrudapi.dto.OrderDto;
import jpa_test.domaincrudapi.repository.ItemRepository;
import jpa_test.domaincrudapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    // 주문 하기
    @Transactional
    public String createOrder(Long itemId){
        Item items = itemRepository.findItemById(itemId)
                .orElseThrow(()-> new IllegalArgumentException("잘못된 입력 정보입니다."+ itemId));

        Order orders = Order.builder()
                .item(items)
                .build();
        orderRepository.save(orders);

        return "주문 성공";
    }


    //주문 조회
    public OrderDto findOrderById(Long id){
        return orderRepository.findOrderById(id)
                .orElseThrow(()->new IllegalArgumentException("잘못된 조회입니다")).toDto();
    }


}
