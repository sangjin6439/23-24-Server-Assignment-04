package jpa_test.domaincrudapi.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jpa_test.domaincrudapi.dto.ItemDto;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "COUNT")
    private Long price;

    public ItemDto toDto(){
        return ItemDto.builder()
                .Id(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }

    public void update(ItemDto itemDto){
        this.name=itemDto.getName();
        this.price=itemDto.getPrice();
    }

}