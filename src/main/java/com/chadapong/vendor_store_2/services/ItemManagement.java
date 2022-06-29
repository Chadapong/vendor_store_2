package com.chadapong.vendor_store_2.services;

import java.util.List;

import com.chadapong.exceptions.ApplicationException;
import com.chadapong.models.Item;
import com.chadapong.vendor_store_2.dtos.ItemDto;
import com.chadapong.vendor_store_2.helpers.ServiceResponseModel;


public interface ItemManagement {
  ServiceResponseModel<Item> createItem(ItemDto model) throws ApplicationException;
  ServiceResponseModel<ItemDto>  getItemByName (String name) throws ApplicationException;
  ServiceResponseModel<List<ItemDto>> getAllItem ();
  ServiceResponseModel<ItemDto> deleteItem (String name) throws ApplicationException;
  ServiceResponseModel<ItemDto> editItem (ItemDto amount);
}
