package jpa_test.domaincrudapi.dto;


import jakarta.persistence.Entity;
import jpa_test.domaincrudapi.domain.Item;
import jpa_test.domaincrudapi.domain.Order;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class ItemDto {

    private Long Id;


    private String name;

    private Long price;

}
