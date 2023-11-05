package jpa_test.domaincrudapi.domain;

import jakarta.persistence.*;
import jpa_test.domaincrudapi.dto.ItemDto;
import jpa_test.domaincrudapi.dto.OrderDto;
import lombok.*;
import org.hibernate.mapping.Join;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="MEMBER_ID")
//    private Member member;

    @OneToOne
    private Item item;

//item->dto 매핑
    public OrderDto toDto(){
        return OrderDto.builder()
                .id(this.id)
                .itemId(this.item)
                .build();
    }

}
