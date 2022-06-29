package com.chadapong.vendor_store_2.mappers;

import com.chadapong.models.Item;
import com.chadapong.vendor_store_2.dtos.ItemDto;

public interface ItemMapper {
  ItemDto toDto(Item item);
}
