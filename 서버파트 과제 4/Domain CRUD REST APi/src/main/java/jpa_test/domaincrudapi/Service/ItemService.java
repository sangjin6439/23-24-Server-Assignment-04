package jpa_test.domaincrudapi.Service;

import jpa_test.domaincrudapi.domain.Item;
import jpa_test.domaincrudapi.dto.ItemDto;
import jpa_test.domaincrudapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.metamodel.internal.MemberResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository; //의존성 주입

    //아이템 생성
    @Transactional
    public void save(ItemDto itemDto) {
        Item item = createItem(itemDto);
        itemRepository.save(item);
    }


    //itemDto -> item
    private Item createItem(ItemDto itemDto) {
        return Item.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .build();
    }

//    //아이템 검색
//    public ItemDto findItem(Long itemId) {
//        return findMemberById(itemId).toDto();
//    }
    //아이디로 아이템 검색
    public ItemDto findItemByIdAs(Long id) {
        return findItemById(id).toDto();
    }

    //아이템 정보 변경
    @Transactional
    public String upDateItem(Long id, ItemDto itemDto) {
        Item item = itemRepository.findItemById(id)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        item.update(itemDto);
        return "수정 성공";
    }

//    private void upDate(ItemDto itemDto,Item item) {
//        item.update(Item.builder()
//                .id(itemDto.getId())
//                .name(itemDto.getName())
//                .price(itemDto.getPrice())
//                .build().toDto());
//    }
    @Transactional
    //아이템 삭제
    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }

    private Item findItemById(Long id){
        return itemRepository.findItemById(id)
                .orElseThrow(()->new IllegalArgumentException("정확한 번호를 입력하세요"));
    }

}
