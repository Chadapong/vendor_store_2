package com.chadapong.vendor_store_2.mappers;

import org.springframework.stereotype.Component;

import com.chadapong.models.Item;
import com.chadapong.vendor_store_2.dtos.ItemDto;

@Component
public class ItemMapperImpl implements ItemMapper {

  @Override
  public ItemDto toDto(Item item) {
    if (item == null) {
      return null;
    }
    ItemDto itemDto = new ItemDto();
    itemDto.setName(item.getName());
    itemDto.setDescription(item.getDescription());
    itemDto.setAmount(item.getAmount());
    return itemDto;
  }
}
