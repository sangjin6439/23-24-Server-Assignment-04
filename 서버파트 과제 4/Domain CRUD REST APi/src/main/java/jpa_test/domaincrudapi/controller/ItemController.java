package jpa_test.domaincrudapi.controller;


import jpa_test.domaincrudapi.Service.ItemService;
import jpa_test.domaincrudapi.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item")
    public void save(@RequestBody ItemDto itemDto){
        itemService.save(itemDto);
    }

    @GetMapping("/item/{id}")
    public ItemDto findItemById(@PathVariable Long id){
        return itemService.findItemByIdAs(id);
    }

    @PutMapping("/item/{id}")
    public String updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto){
        return itemService.upDateItem(id,itemDto);
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }

}
