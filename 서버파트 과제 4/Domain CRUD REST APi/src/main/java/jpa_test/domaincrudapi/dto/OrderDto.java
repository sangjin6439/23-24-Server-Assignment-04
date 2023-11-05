package jpa_test.domaincrudapi.dto;


import jpa_test.domaincrudapi.domain.Item;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Getter
public class OrderDto {

    private Long id;
//    private Member memberId;
    private Item itemId;

}
